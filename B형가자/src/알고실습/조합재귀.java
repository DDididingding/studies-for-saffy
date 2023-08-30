package 알고실습;

public class 조합재귀 {
	public static String[] 재료 = {"오이", "우엉", "햄", "참치"};
	public static int N = 4;
	public static boolean[] sel = new boolean[N];
	
	public static void main(String[] args) {
		powerset(0);
	}
	
	public static void powerset (int idx) {
		//기저파트
		if(idx==N) {//모든 재료를 다 판단했다
			for(int i = 0 ; i<N; i++) {
				if(sel[i])
					System.out.print(재료[i]);
			}
			System.out.println();
			return;
		}
		//재귀파트
		
			sel[idx] = true;
			powerset(idx+1);
			
			sel[idx] = false;
			powerset(idx+1);
		
	}

}
