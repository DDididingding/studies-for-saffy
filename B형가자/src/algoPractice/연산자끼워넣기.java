package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class �����ڳ����ֱ� {

	static int nums[];
	static int N;
	static int maxResult;
	static int minResult;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		str = br.readLine().split(" ");
		int[] cal = new int[4];

		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(str[i]);
		}
		maxResult = Integer.MIN_VALUE;
		minResult = Integer.MAX_VALUE;

		�������(1, cal[0], cal[1], cal[2], cal[3], nums[0]);

		System.out.println(maxResult);
		System.out.println(minResult);

	}

	private static void �������(int idx, int plus, int minus, int multiple, int devide, int result) {
		if (plus == 0 && minus == 0 && multiple == 0 && devide == 0) {
			if (result > maxResult)
				maxResult = result;
			if (result < minResult)
				minResult = result;
		}

		if (plus != 0) {
			�������(idx + 1, plus - 1, minus, multiple, devide, result + nums[idx]);
		}
		if (minus != 0) {
			�������(idx + 1, plus, minus - 1, multiple, devide, result - nums[idx]);
		}
		if (multiple != 0) {
			�������(idx + 1, plus, minus, multiple - 1, devide, result * nums[idx]);
		}
		if (devide != 0) {
			if (result < 0) {
				�������(idx + 1, plus, minus, multiple, devide - 1, Math.abs(result) / nums[idx] * -1);
			} else {
				�������(idx + 1, plus, minus, multiple, devide - 1, result / nums[idx]);
			}

		}
	}
}
