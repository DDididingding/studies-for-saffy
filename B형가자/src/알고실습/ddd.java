package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ddd {

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
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startY = i;
					startX = j;
					visited = new int[101];
					오른쪽아래(i + 1, j + 1, 1);
				}
			}

			System.out.println("#" + t + " " + maxDessert);

		}

	}

	static void 오른쪽아래(int y, int x, int cnt) {
		// 탈출 조건
		// 1. 인덱스 탈출
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. 같은 디저트 두번 먹음

		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;
		// 재귀
		오른쪽아래(y + 1, x + 1, cnt + 1);
		왼쪽아래(y + 1, x - 1, cnt + 1);
		visited[map[y][x]]--;
	}

	static void 왼쪽아래(int y, int x, int cnt) {
		// 탈출 조건
//        System.out.println("오른쪽 아래");
		// 1. 인덱스 탈출
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. 같은 디저트 두번 먹음
		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;

		// 재귀
		왼쪽아래(y + 1, x - 1, cnt + 1);
		왼쪽위(y - 1, x - 1, cnt + 1);
		visited[map[y][x]]--;
	}

	static void 왼쪽위(int y, int x, int cnt) {
		// 탈출 조건
//        System.out.println("왼쪽 위");
		// 1. 인덱스 탈출
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. 같은 디저트 두번 먹음

		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;

		// 재귀
		왼쪽위(y - 1, x - 1, cnt + 1);
		오른쪽위(y - 1, x + 1, cnt + 1);
		visited[map[y][x]]--;
	}

	static void 오른쪽위(int y, int x, int cnt) {
		// 탈출 조건
//        System.out.println("오른쪽 위");
		// 1. 인덱스 탈출
		if (y >= N || y < 0 || x >= N || x < 0) {
			return;
		}
		// 2. 같은 디저트 두번 먹음

		if (visited[map[y][x]] == 1) {
			return;
		}
		visited[map[y][x]]++;
		// 3. 시작점보다 높이 올라가면(== 사각형이 안되면)탈출
        if (y < startY) {
            return;
        }
		// 4. 시작점으로 돌아오면
		if (y == startY && x == startX) {
			if (maxDessert < cnt)
				maxDessert = cnt;
		}
		// 재귀
		오른쪽위(y - 1, x + 1, cnt + 1);
		visited[map[y][x]]--;
	}

}