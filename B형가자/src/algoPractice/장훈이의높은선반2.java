package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class �������ǳ�������2 {
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
				int sum = 0; // �߰���
				for (int j = 0; j < N; j++) { // �̰� ���̸� j��° ������ �̹� ž�� ���Եƴ� ��� �̾߱�
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
		// �����κ�
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
		// ��ͺκ�
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;
		powerset(idx + 1);
	}
}
