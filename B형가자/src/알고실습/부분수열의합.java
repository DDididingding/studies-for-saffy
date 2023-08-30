package 알고실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분수열의합 {

	static int N;
	static int K;
	static boolean[] isVisited;
	static int cnt;
	static int[] nums;
	static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);

			str = br.readLine().split(" ");
			nums = new int[N];
			for (int n = 0; n < N; n++) {
				nums[n] = Integer.parseInt(str[n]);
			}
			sum = 0;
			cnt = 0;
			isVisited = new boolean[N];
			조합(0);
			System.out.println("#"+t+" "+cnt);

		}
	}

	static void 조합(int idx) {
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (isVisited[i]) {
					sum += nums[i];
				}

			}
			if (sum == K) {
				cnt++;
			}
			sum = 0;
			return;
		}

		isVisited[idx] = true;
		조합(idx + 1);
		isVisited[idx] = false;
		조합(idx + 1);

	}

}
