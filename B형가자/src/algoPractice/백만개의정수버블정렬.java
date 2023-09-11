package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �鸸���������������� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = str.length;
		int[] nums = new int[N];
		
		for(int i = 0 ; i<N; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		
		int now = 0;
		int idx = N-1;
		while(idx > 0) {
			for(now = 0; now<idx; now++) {
				if(nums[now]>nums[now+1]) {
					int temp = nums[now];
					nums[now] = nums[now +1];
					nums[now+1] = temp;
				}
			}
			idx--;
			
		}
//		System.out.println(Arrays.toString(nums));
		System.out.println(nums[500000]);
		
	}

}
