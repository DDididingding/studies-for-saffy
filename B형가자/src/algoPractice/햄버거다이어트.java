package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class �ܹ��Ŵ��̾�Ʈ {
	
	static int N;
	static int L;
	static int[][] ���;
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
			��� = new int[N][2];
			for(int n =0; n<N; n++) {
				str = br.readLine().split(" ");
				���[n][0] = Integer.parseInt(str[0]);
				���[n][1] = Integer.parseInt(str[1]);
			}
			
			maxMat = 0;
			matSum = 0;
			calSum = 0;
			isVisited = new boolean[N];
			����(0);
			
			System.out.println("#" + t+ " "+ maxMat);
			
		}
	}
	
	static void ����(int idx) {
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				if(isVisited[i] == true) {
					matSum += ���[i][0];
					calSum += ���[i][1];
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
		����(idx+1);
		isVisited[idx] = true;
		����(idx+1);
		
	}

}
