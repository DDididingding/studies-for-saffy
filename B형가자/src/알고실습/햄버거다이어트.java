package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 햄버거다이어트 {
	
	static int N;
	static int L;
	static int[][] 재료;
	static boolean[] isVisited;
	static int maxMat;
	static int matSum;
	static int calSum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			L = Integer.parseInt(str[1]);
			재료 = new int[N][2];
			for(int n =0; n<N; n++) {
				str = br.readLine().split(" ");
				재료[n][0] = Integer.parseInt(str[0]);
				재료[n][1] = Integer.parseInt(str[1]);
			}
			
			maxMat = 0;
			matSum = 0;
			calSum = 0;
			isVisited = new boolean[N];
			조합(0);
			
			System.out.println("#" + t+ " "+ maxMat);
			
		}
	}
	
	static void 조합(int idx) {
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				if(isVisited[i] == true) {
					matSum += 재료[i][0];
					calSum += 재료[i][1];
				}
			}
			if(calSum<=L) {
				if(matSum>maxMat) maxMat = matSum;
			}
			calSum = 0;
			matSum = 0;
			return;
		}
		
		isVisited[idx] = false;
		조합(idx+1);
		isVisited[idx] = true;
		조합(idx+1);
		
	}

}
