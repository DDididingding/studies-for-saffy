package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ����Ʈī�� {

	static int startX;
	static int startY;
	static int[] visited;
	static int maxDessert;
	static int[][] map;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			maxDessert = -1;
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					startY = i;
					startX = j;
					visited = new int[101];
					�����ʾƷ�(i + 1, j + 1, 1);
				}
			}

			System.out.println("#" + t + " " + maxDessert);

		}

	}

	static void �����ʾƷ�(int y, int x, int cnt) {
		// Ż�� ����
		// 1. �ε��� Ż��
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. ���� ����Ʈ �ι� ����

		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;
		// ���
		�����ʾƷ�(y + 1, x + 1, cnt + 1);
		���ʾƷ�(y + 1, x - 1, cnt + 1);
		visited[map[y][x]]--;
	}

	static void ���ʾƷ�(int y, int x, int cnt) {
		// Ż�� ����
//		System.out.println("������ �Ʒ�");
		// 1. �ε��� Ż��
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. ���� ����Ʈ �ι� ����
		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;

		// ���
		���ʾƷ�(y + 1, x - 1, cnt + 1);
		������(y - 1, x - 1, cnt + 1);
		visited[map[y][x]]--;
	}

	static void ������(int y, int x, int cnt) {
		// Ż�� ����
//		System.out.println("���� ��");
		// 1. �ε��� Ż��
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. ���� ����Ʈ �ι� ����

		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;

		// ���
		������(y - 1, x - 1, cnt + 1);
		��������(y - 1, x + 1, cnt + 1);
		visited[map[y][x]]--;
	}

	static void ��������(int y, int x, int cnt) {
		// Ż�� ����
//		System.out.println("������ ��");
		// 1. �ε��� Ż��
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. ���� ����Ʈ �ι� ����

		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;
		// 3. ���������� ���� �ö󰡸�(== �簢���� �ȵǸ�)Ż��
		if (y < startY) {
			return;
		}
		// 4. ���������� ���ƿ���
		if (y == startY && x == startX) {
			if (maxDessert < cnt)
				maxDessert = cnt;
//			return;
		}
		// ���
		��������(y - 1, x + 1, cnt + 1);
		visited[map[y][x]]--;
		
	}

}
