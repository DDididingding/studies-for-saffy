package 알고실습;

import java.util.Arrays;

public class 조합01 {
	public static String[] 토핑 = {"상추", "패티", "토마토", "치즈","새우"};
	public static int N = 5;
	public static int R = 2;
	public static String[] sel = new String[R];
	public static void main(String[] args) {
		
	}
	
	
	//idx : 토핑의 index
	//sidx ; sel의 index
	public static void combination(int idx, int sidx) {
		//기저파트
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) return;
		
		//재귀파트
		sel[sidx] = 토핑[idx]; //해당 재료 넣어보자
		combination(idx+1, sidx+1);// idx번째 재료 뽑은거
		combination(idx+1, sidx); //idx번째 재료 안뽑은거
		
	}

}
