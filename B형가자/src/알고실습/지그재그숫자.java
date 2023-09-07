package 알고실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지그재그숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			if (N % 2 == 0) {
				System.out.println("#" + t + " " + -(N / 2));
			} else {
				N = -((N - 1) / 2) + N;
				System.out.println("#" + t + " " + N);
			}
		}

	}
}
