package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class �Ӹ���Ҽ� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str= br.readLine();
			if(str .equals("0")) break;
			for(int i = 0; i<=str.length()/2; i++) {
				if(str.charAt(i) != str.charAt(str.length()-1-i)) {
					System.out.println("no");
					break;
				}else if(i==str.length()/2) System.out.println("yes");
			}
			
		}
	}
}
