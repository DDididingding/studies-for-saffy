package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �ܾ����� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] result = new String[N];
		for(int n = 0; n<N; n++) {
			result[n] = br.readLine();
		}
		Arrays.sort(result);
		
		for(int i = 1; i<N; i++) {
			if(result[i-1].equals(result[i])) {
				result[i-1] = "";
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				if(result[i].length()>result[j].length()) {
					String temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			if(!result[i].equals("")) {
				System.out.println(result[i]);
			}
			
		}
	}

}
