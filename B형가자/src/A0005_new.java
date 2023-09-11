import java.net.*;
import java.io.*;

public class A0005_new {

    static final String NICKNAME = "DAEJEON02_JAVA";
    static final String HOST = "127.0.0.1";
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

    public static void main(String[] args) {

        Socket socket = null;
        String recvData = null;
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

            String sendData = CODE_SEND + "/" + NICKNAME + "/";
            bytes = sendData.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {
                // Receive Data
                bytes = new byte[1024];
                int countByte = is.read(bytes);
                recvData = new String(bytes, 0, countByte, "UTF-8");
                System.out.println("Data Received: " + recvData);

                // Read Game Data
                String[] splitData = recvData.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(splitData[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been corrupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int) balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : " second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float whiteBallX = balls[0][0];
                float whiteBallY = balls[0][1];

                // Find the closest ball to target
                int closestBallIndex = findClosestBall(balls, whiteBallX, whiteBallY);
                float targetBallX = balls[closestBallIndex][0];
                float targetBallY = balls[closestBallIndex][1];

                // Calculate the angle and power
                double[] angleAndPower = calculateAngleAndPower(whiteBallX, whiteBallY, targetBallX, targetBallY);
                float angle = (float) angleAndPower[0];
                double power = angleAndPower[1];

                // Send Data
                String mergedData = angle + "/" + power + "/";
                bytes = mergedData.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + mergedData);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find the closest ball to the target
    private static int findClosestBall(float[][] balls, float whiteBallX, float whiteBallY) {
        int closestBallIndex = -1;
        double minDistance = Double.MAX_VALUE;
        
        for (int i = 1; i < NUMBER_OF_BALLS; i++) {
            if (balls[i][0] != -1) {
                double distance = calculateDistance(whiteBallX, whiteBallY, balls[i][0], balls[i][1]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestBallIndex = i;
                }
            }
        }
        
        return closestBallIndex;
    }

    // Calculate the angle and power
    private static double[] calculateAngleAndPower(float whiteBallX, float whiteBallY, float targetBallX, float targetBallY) {
        double angle = 0.0;
        double power = 87.0; // 힘을 87로 고정

        // 흰 공과 목적구의 X, Y 좌표 차이를 계산합니다.
        double deltaX = targetBallX - whiteBallX;
        double deltaY = targetBallY - whiteBallY;

        // 아크탄젠트를 사용하여 각도를 계산합니다.
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        // 각도가 음수이면 양수로 변환합니다.
        if (angle < 0) {
            angle += 360;
        }

        return new double[]{angle, power};
    }

    // Calculate the distance between two points
    private static double calculateDistance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
