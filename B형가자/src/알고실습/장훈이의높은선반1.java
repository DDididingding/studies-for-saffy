package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 장훈이의높은선반1 {
	static int N, B, ans;
	static int[] H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			B = Integer.parseInt(str[1]);
			H = new int[N];

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
}
