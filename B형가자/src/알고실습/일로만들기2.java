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
		Arrays.fill(nums, Integer.MAX_VALUE);
		��������(X,0);
		System.out.println(nums[X]);
	}
	
	static void ��������(int n, int cnt) {ss
		if(n < 1 ) return;
		if(n == 1 && nums[1]>cnt) {
			nums[n] = cnt;
			return;
	}
		if(n%3 == 0)
		��������(n*3, cnt+1);
		if(n%2 == 0)
		��������(n*2, cnt+1);
		��������(n+1, cnt+1);
		
		
	}
}
