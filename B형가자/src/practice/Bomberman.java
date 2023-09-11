package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bomberman {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int R = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);
		int N = Integer.parseInt(str[2]);
		
		String[][] bomb = new String[R][C];
		int [][] timebomb = new int[R][C];
		int [][] timebombTemp = new int[R][C];
		
		int[] dely = {0,0,1,-1}; //우,좌,하,상
		int[] delx = {1,-1,0,0};
		for(int i = 0; i<R; i++) {
			str = br.readLine().split("");
			for(int j = 0; j<C; j++) {
				bomb[i][j] = str[j];
				if(str[j].equals("O")){
					timebomb[i][j] = 3;
				}
			}
		}
		
		//input complete
		
		for(int i = 0; i<R; i++) { // after 1sec
			for(int j = 0; j<C; j++) {
				if(timebomb[i][j]>0) {
					timebomb[i][j]--;
				}
			}
		}
		N--;
		
		while(N>0) {
			for(int i = 0; i<R; i++) { // bomb sec--
				for(int j = 0; j<C; j++) {
					if(timebomb[i][j]>0) {
						timebomb[i][j]--;
					}else {
						timebomb[i][j] = 3;//bomb install	
					}
				}
			}
			
			for(int i = 0; i<R; i++) { // bomb sec--, explode
				for(int j = 0; j<C; j++) {
					if(timebomb[i][j] == 1) {//explode after 1sec
						for(int d=0; d<4; d++) {
							if(i+dely[d] <0|| i+dely[d]>=R || j+delx[d]<0|| j+delx[d]>=C) { //explosion
								continue;	
							}
							timebomb[i+dely[d]][j+delx[d]] = 0;	
						}
						timebomb[i][j] = 0;
					}
				}
			}
			N--; //1sec
			if(N == 0) break;
			
			for(int i = 0; i<R; i++) { // bomb sec--
				for(int j = 0; j<C; j++) {
					if(timebomb[i][j]>0) {
						timebomb[i][j]--;
					}
				}
			}
		}
		
	}
}
