package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 요리사 {

	static boolean[] ingredients;
	static int N;
	static int[][] synergy;
	static int food1;
	static int food2;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			String[] str;
			for (int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(str[j]);
				}
			}

			ingredients = new boolean[N];
			food1 = 0;
			food2 = 0;
			min = Integer.MAX_VALUE;

			select(0, 0);

			System.out.println("#" + t + " " + min);
		}

	}

	static void select(int idx, int cnt) {

		if (cnt == N / 2) {
			score(ingredients);
			return;
		}
		if (idx >= N)
			return;

		ingredients[idx] = true;
		select(idx + 1, cnt + 1);
		ingredients[idx] = false;
		select(idx + 1, cnt);

	}

	static void score(boolean[] ingredients) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (ingredients[i] && ingredients[j]) {
					food1 += synergy[i][j];
				}
				if (!ingredients[i] && !ingredients[j]) {
					food2 += synergy[i][j];
				}
			}
		}

		if (Math.abs(food1 - food2) < min)
			min = Math.abs(food1 - food2);
		food1 = 0;
		food2 = 0;
	}
}
