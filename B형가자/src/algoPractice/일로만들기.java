package algoPractice;
package �˰�ǽ�;

import java.util.*;
import java.io.*;
public class �Ϸθ���� {
	
	static int[] nums;
	static int X;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		nums = new int[1000001];
		Arrays.fill(nums, Integer.MAX_VALUE);
		�ö���(1,0);
		System.out.println(nums[X]);
	}
	
	static void �ö���(int n, int cnt) {
		if(n>X+1) return;
		if(nums[n]<=cnt) return;
		if(nums[n]>cnt)
			nums[n] = cnt;
		
		�ö���(n*3, cnt+1);
		�ö���(n*2, cnt+1);
		if(nums[n+1]<cnt)
		�ö���(n+1, cnt+1);
		
		
	}
}
