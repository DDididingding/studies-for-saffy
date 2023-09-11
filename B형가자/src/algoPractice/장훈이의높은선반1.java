package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class �������ǳ�������1 {
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
}
