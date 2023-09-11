package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ��ȭ������ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int i = 666;
		while(true) {
			if(cnt == N) {
				System.out.println(i);
				break;
			}
			i++;
			String I = Integer.toString(i);
			if(I.contains("666")) cnt++;
		}
		
		
	}
}
