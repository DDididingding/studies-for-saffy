package 알고실습;

import java.util.*;
import java.io.*;

public class 차이를최대로 {
	
	static int N;
	static int[] nums;
	static int[] results;
	static int sum;
	static int maxSum;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		
		maxSum = 0;
		visited = new boolean[N];
		results = new int[N];
		perm(0,0);
		System.out.println(maxSum);
		
	}
	
	static void perm(int cnt, int idx) {
		if(cnt == N) {
			int sum  = 0;
			for(int i = 1; i<N; i++) {
				sum += Math.abs(results[i-1] - results[i]);
			}
//			System.out.println(Arrays.toString(results));
			if(sum>maxSum) maxSum = sum;
		}

		
		for(int i = 0; i<N; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				results[cnt] = nums[i];
				perm(cnt+1, i);
				visited[i] = false;
			}
		}
		
	}

}
