package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ��ȣ�ǹ�Ʋ�ʵ� {
	static String[][] map;
	static int[] tank;
	static int h;
	static int w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			h = Integer.parseInt(str[0]);
			w = Integer.parseInt(str[1]);
			map = new String[h][w];
			tank = new int[3];// y,x,����

			for (int i = 0; i < h; i++) {
				str = br.readLine().split("");
				for (int j = 0; j < w; j++) {
					map[i][j] = str[j];
					if (str[j].equals("^")) {
						tank[0] = i;
						tank[1] = j;
						tank[2] = 1;
					} else if (str[j].equals("v")) {
						tank[0] = i;
						tank[1] = j;
						tank[2] = 2;
					} else if (str[j].equals("<")) {
						tank[0] = i;
						tank[1] = j;
						tank[2] = 3;
					} else if (str[j].equals(">")) {
						tank[0] = i;
						tank[1] = j;
						tank[2] = 4;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			str = br.readLine().split("");


			for (int i = 0; i < N; i++) {
				���(str[i]);
			}
			
			System.out.print("#"+t + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static void ���(String order) {
		if (order.equals("U")) { // ��
			tank[2] = 1;
			map[tank[0]][tank[1]] = "^";
			if (tank[0] - 1 >= 0 && map[tank[0] - 1][tank[1]].equals(".")) {
				map[tank[0]][tank[1]] = ".";
				map[tank[0] - 1][tank[1]] = "^";
				tank[0]--;
			}
		}
		if (order.equals("D")) { // ��
			tank[2] = 2;
			map[tank[0]][tank[1]] = "v";
			if (tank[0] + 1 < h && map[tank[0] + 1][tank[1]].equals(".")) {
				map[tank[0]][tank[1]] = ".";
				map[tank[0] + 1][tank[1]] = "v";
				tank[0]++;
			}
		}
		if (order.equals("L")) { // ��
			tank[2] = 3;
			map[tank[0]][tank[1]] = "<";
			if (tank[1] - 1 >= 0 && map[tank[0]][tank[1] - 1].equals(".")) {
				map[tank[0]][tank[1]] = ".";
				map[tank[0]][tank[1] - 1] = "<";
				tank[1]--;
			}
		}
		if (order.equals("R")) { // ��
			tank[2] = 4;
			map[tank[0]][tank[1]] = ">";
			if (tank[1] + 1 < w && map[tank[0]][tank[1] + 1].equals(".")) {
				map[tank[0]][tank[1]] = ".";
				map[tank[0]][tank[1] + 1] = ">";
				tank[1]++;
			}
		}

		if (order.equals("S")) {
			switch (tank[2]) {
			case 1:
				for (int i = tank[0]; i >= 0; i--) {
					if (map[i][tank[1]].equals("*")) {
						map[i][tank[1]] = ".";
						break;
					} else if (map[i][tank[1]].equals("#")) {
						break;
					}
				}
				break;
			case 2:
				for (int i = tank[0]; i < h; i++) {
					if (map[i][tank[1]].equals("*")) {
						map[i][tank[1]] = ".";
						break;
					} else if (map[i][tank[1]].equals("#")) {
						break;
					}
				}
				break;
			case 3:
				for (int i = tank[1]; i >= 0; i--) {
					if (map[tank[0]][i].equals("*")) {
						map[tank[0]][i] = ".";
						break;
					} else if (map[tank[0]][i].equals("#")) {
						break;
					}
				}
				break;
			case 4:
				for (int i = tank[1]; i < w; i++) { //x��ǥ
					if (map[tank[0]][i].equals("*")) {//y��ǥ
						map[tank[0]][i] = ".";
						break;
					} else if (map[tank[0]][i].equals("#")) {
						break;
					}
				}
				break;
			}
		}
	}
}
