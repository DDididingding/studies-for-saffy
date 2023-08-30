package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 체스판다시칠하기 {
	
	static int ver1;
	static int ver2;
	static int min;
	static String[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		map = new String[N][M];
		min = Integer.MAX_VALUE;
		
		
		for(int i = 0; i<N; i++) {
			str = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				map[i][j] = str[j];
			}
		}
		
		for(int i = 0; i<N-7; i++) {
			for(int j = 0; j<M-7; j++) {

				체스판검사1(i,j);
				체스판검사2(i,j);
			}
		}
		
		System.out.println(min);
		
	}
	
	static void 체스판검사1(int i, int j) {
		ver1 = 0;
		for(int row = 0; row<8; row++ ) {
			for(int col = 0; col<8; col++) {
				if(row%2 ==0 && col%2 ==0) {
					if(!map[i+row][j+col].equals("B")) ver1++;
				}else if(row%2 ==0 && col%2 ==1) {
					if(!map[i+row][j+col].equals("W")) ver1++;
				}else if(row%2 ==1 && col%2 ==0) {
					if(!map[i+row][j+col].equals("W")) ver1++;
				}else if(row%2 ==1 && col%2 ==1) {
					if(!map[i+row][j+col].equals("B")) ver1++;
				}
			}
		}
		
		if(ver1<min) min = ver1;
	}
	
	static void 체스판검사2(int i, int j) {
		ver1 = 0;
		for(int row = 0; row<8; row++ ) {
			for(int col = 0; col<8; col++) {
				if(row%2 ==0 && col%2 ==0) {
					if(!map[i+row][j+col].equals("W")) ver1++;
				}else if(row%2 ==0 && col%2 ==1) {
					if(!map[i+row][j+col].equals("B")) ver1++;
				}else if(row%2 ==1 && col%2 ==0) {
					if(!map[i+row][j+col].equals("B")) ver1++;
				}else if(row%2 ==1 && col%2 ==1) {
					if(!map[i+row][j+col].equals("W")) ver1++;
				}
			}
		}
		
		if(ver1<min) min = ver1;
	}
	
}
