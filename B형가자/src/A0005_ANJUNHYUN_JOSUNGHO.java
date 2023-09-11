import java.net.*;
import java.util.Random;
import java.io.*;

public class A0005_ANJUNHYUN_JOSUNGHO {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "DAEJEON02_JAVA";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				double power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];

				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				float targetBall_x = -2;
				float targetBall_y = -2;

				double distance1 = Integer.MAX_VALUE;
				double distance2 = Integer.MAX_VALUE;
				double distance3 = Integer.MAX_VALUE;
				double distance4 = Integer.MAX_VALUE;
				double distance5 = Integer.MAX_VALUE;
				
				if(balls[1][0] != -1) {
					distance1 = Math.sqrt(Math.pow(Math.abs(balls[1][0] - whiteBall_x), 2)+Math.pow(Math.abs(balls[1][1] - whiteBall_y), 2));
				}
				if(balls[2][0] != -1) {
					distance2 = Math.sqrt(Math.pow(Math.abs(balls[2][0] - whiteBall_x), 2)+Math.pow(Math.abs(balls[2][1] - whiteBall_y), 2));
				}
				if(balls[3][0] != -1) {
					distance3 = Math.sqrt(Math.pow(Math.abs(balls[3][0] - whiteBall_x), 2)+Math.pow(Math.abs(balls[3][1] - whiteBall_y), 2));
				}
				if(balls[4][0] != -1) {
					distance4 = Math.sqrt(Math.pow(Math.abs(balls[4][0] - whiteBall_x), 2)+Math.pow(Math.abs(balls[4][1] - whiteBall_y), 2));
				}
				if(balls[5][0] != -1) {
					distance5 = Math.sqrt(Math.pow(Math.abs(balls[5][0] - whiteBall_x), 2)+Math.pow(Math.abs(balls[5][1] - whiteBall_y), 2));
				}
				
				if(order == 1) {
					if (balls[1][0] != -1) {//1번공 있으면
						if(balls[3][0] != -1) {//3번공 있으면
							if(distance1<=distance3) {//거리비교해서 더 작은 걸로 공 고르기
								targetBall_x = balls[1][0];
								targetBall_y = balls[1][1];
							}else {
								targetBall_x = balls[3][0];
								targetBall_y = balls[3][1];
							}
						}else {//1번공 있는데 3번공 없으면
							targetBall_x = balls[1][0];
							targetBall_y = balls[1][1];
						}
						
					} else if (balls[3][0] != -1) {//3번공 있으면
						targetBall_x = balls[3][0];
						targetBall_y = balls[3][1];
					} else if (balls[5][0] != -1) {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					}
				}
				if(order == 2) {
					if (balls[2][0] != -1) {//1번공 있으면
						if(balls[4][0] != -1) {//3번공 있으면
							if(distance1<=distance3) {//거리비교해서 더 s작은 걸로 공 고르기
								targetBall_x = balls[2][0];
								targetBall_y = balls[2][1];
							}else {
								targetBall_x = balls[4][0];
								targetBall_y = balls[4][1];
							}
						}else {//1번공 있는데 3번공 없으면
							targetBall_x = balls[2][0];
							targetBall_y = balls[2][1];
						}
						
					} else if (balls[4][0] != -1) {//3번공 있으면
						targetBall_x = balls[4][0];
						targetBall_y = balls[4][1];
					} else if (balls[5][0] != -1) {
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
					}
				}
				
				//targetball과 각 pocket 사이의 거리 구하기
				double min = Integer.MAX_VALUE;
				double toGoal = 0;
				float targetHole_x = 0;
				float targetHole_y = 0;
				for(int i = 0 ; i< 6; i++) {
					toGoal = Math.sqrt(Math.pow(Math.abs(targetBall_x - HOLES[i][0]), 2)+Math.pow(Math.abs(targetBall_y - HOLES[i][1]), 2));
					if(min>toGoal) {
						min = toGoal;//가장 가까운 포켓을 목표 포켓으로 지정
						targetHole_x = HOLES[i][0];
						targetHole_y = HOLES[i][1];
					}
				}
				
				//흰공과 포켓과의 거리
				double d_White_Hole = Math.sqrt(Math.pow(Math.abs(targetHole_x - whiteBall_x), 2)+Math.pow(Math.abs(targetHole_y - whiteBall_y), 2));
				
				//width1, height1: 목적구와 목적포켓간의 x, y거리
				float width1 = Math.abs(targetBall_x - targetHole_x);
				float height1 = Math.abs(targetBall_y - targetHole_y); 
				
				
				
				
				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width = Math.abs(targetBall_x - whiteBall_x);
				float height = Math.abs(targetBall_y - whiteBall_y);

				//목적구와 흰공간의 거리
				double d_White_Target = Math.sqrt((width*width)+(height*height));
				//포켓과 목적구의 거리
				double d_Hole_Target = Math.sqrt(Math.pow(Math.abs(targetHole_x - targetBall_x), 2)+Math.pow(Math.abs(targetHole_y - targetBall_y), 2));
				
				//흰공을 중심으로 목적구, 목적홀 사이의 각
				double alpha = Math.acos((Math.pow(d_White_Hole, 2)+Math.pow(d_White_Target, 2)-Math.pow(d_Hole_Target, 2))/(2*d_White_Hole*d_White_Target));
				//흰공과 포켓 사이의 각
				double beta = Math.atan(Math.abs(targetHole_y-whiteBall_y)/Math.abs(targetHole_x-whiteBall_x));
				
				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				// - 1radian = 180 / PI (도)
				// - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian = height > 0 ? Math.atan(width / height) : 0;
				angle = (float) ((180.0 / Math.PI) * radian);

				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == targetBall_x) {
					if (whiteBall_y < targetBall_y) {
						angle = 0;	
					} else {
						angle = 180;
					}
				} else if (whiteBall_y == targetBall_y) {
					if (whiteBall_x < targetBall_x) {
						angle = 90;
					} else {
						angle = 270;
					}
				}

				// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산
				if (whiteBall_x < targetBall_x && whiteBall_y < targetBall_y) {
					radian = Math.atan(width / height);
					angle = (float) (((180.0 / Math.PI) * radian) + 0);
//					float angle1 = (float) (((180.0 / Math.PI) * (beta-alpha)) + 0);
//					float angle2 = (float) (((180.0 / Math.PI) * (alpha)) + 0);
//					System.out.println(angle1+ " "+angle2);
//					angle = angle1 + angle2;
				}

				// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
					radian = Math.atan(height / width);
					angle = (float) (((180.0 / Math.PI) * radian) - 90);
				}
				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
					radian = Math.atan(width / height);
					angle = (float) (((180.0 / Math.PI) * radian) + 180);
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
					radian = Math.atan(height / width);
					angle = (float) (((180.0 / Math.PI) * radian) + 90);
				}


				// power: 거리 distance에 따른 힘의 세기를 계산
				if(d_White_Target>40) {
					power = d_White_Target;
				}else {power=100;}
				
				
				

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
