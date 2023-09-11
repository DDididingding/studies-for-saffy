package algoPractice;
package �˰�ǽ�;


import java.io.*;
import java.util.*;

public class ��� {
	
	static int N;
	static int[] T;
	static int[] P;
	static int maxSum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N+1];
		P = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			T[i] = Integer.parseInt(str[0]);
			P[i] = Integer.parseInt(str[1]);
			
		}
		
		ruJ(1,0);
		System.out.println(maxSum);
	}
	
	static void ruJ(int day, int sum) {
		if(day>N) {
			
			if(sum>maxSum) maxSum = sum;
			return;
		}
		
		//�������
		if(day+T[day]>N+1) {
			ruJ(day+T[day], sum);
		}else {
			ruJ(day+T[day], sum+P[day]);
		}
		
		//�Ȱ������
		ruJ(day+1, sum);
	}

}
