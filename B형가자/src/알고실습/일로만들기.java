package 알고실습;

import java.util.*;
import java.io.*;
public class 일로만들기 {
	
	static int[] nums;
	static int X;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		nums = new int[1000001];
		Arrays.fill(nums, Integer.MAX_VALUE);
		올라가자(1,0);
		System.out.println(nums[X]);
	}
	
	static void 올라가자(int n, int cnt) {
		if(n>X+1) return;
		if(nums[n]<=cnt) return;
		if(nums[n]>cnt)
			nums[n] = cnt;
		
		올라가자(n*3, cnt+1);
		올라가자(n*2, cnt+1);
		if(nums[n+1]<cnt)
		올라가자(n+1, cnt+1);
		
		
	}
}
