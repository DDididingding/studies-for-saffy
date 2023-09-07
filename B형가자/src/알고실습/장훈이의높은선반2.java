package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 장훈이의높은선반2 {
	static int N, B, ans;
	static int[] H;
	static boolean[] sel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			B = Integer.parseInt(str[1]);
			H = new int[N];
			sel = new boolean[N];

			str = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(str[i]);
			}

			ans = Integer.MAX_VALUE;

			for (int i = 0; i < (1 << N); i++) {
				int sum = 0; // 중간합
				for (int j = 0; j < N; j++) { // 이게 참이면 j번째 점원이 이번 탑에 포함됐다 라는 이야기
					if ((i & (1 << j)) != 0) {
						sum += H[j];
					}
				}

				if (sum >= B && sum < ans)
					ans = sum;

			}

			System.out.println("#" + t + " " + (ans - B));
		}
	}

	static void powerset(int idx) {
		// 기저부분
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += H[i];
				}
			}
			if (sum >= B)
				ans = Math.min(ans, sum);
			return;
		}
		// 재귀부분
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;
		powerset(idx + 1);
	}
}
