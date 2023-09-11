package algoPractice;
package �˰�ǽ�;

import java.util.*;
import java.io.*;
public class �Ϸθ����2 {
	
	static int[] nums;
	static int X;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		nums = new int[1000001];
		
		Arrays.fill(nums, 100000);
		nums[1]= 0;
		for(int i = 1; i<X; i++) {
			nums[i+1] = Math.min(nums[i+1], nums[i]+1);
			if(i*2<X+1) {
				nums[i*2] = Math.min(nums[i*2], nums[i]+1);
			}
			if(i*3<X+1) {
				nums[i*3] = Math.min(nums[i*3], nums[i]+1);
			}
		}
		System.out.println(nums[X]);
	}

}
