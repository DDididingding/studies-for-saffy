package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ������ǥ�� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int result = 0;
			result = M & ((int)Math.pow(2, N))-1;
			
			if(result == ((int)Math.pow(2, N))-1) {
				System.out.println("#"+t+" ON");
			}else {
				System.out.println("#"+t+" OFF");
			}
			
		}
	}

}
