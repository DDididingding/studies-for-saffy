package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �ܼ�2����ȣ�ڵ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			int h = Integer.parseInt(str[0]);
			int w = Integer.parseInt(str[1]);
			String s = new String();
			String[] code = new String[8];
			boolean nocode = true;
			for (int i = 0; i < h; i++) {
				s = br.readLine();
				for (int j = w - 1; j >= 0; j--) {
					if (s.charAt(j) == '1'&&nocode) {
						code[7] = s.substring(j-6, j+1);
						code[6] = s.substring(j-13, j-6);
						code[5] = s.substring(j-20, j-13);
						code[4] = s.substring(j-27, j-20);
						code[3] = s.substring(j-34, j-27);
						code[2] = s.substring(j-41, j-34);
						code[1] = s.substring(j-48, j-41);
						code[0] = s.substring(j-55, j-48);
						nocode = false;
						break;
					}
				}
			}
			int sum = 0;
			for(int i = 0; i<8; i++) {
				sum += ��ȣ�ص���(code[i]);
			}
			int result = (��ȣ�ص���(code[0])+��ȣ�ص���(code[2])+��ȣ�ص���(code[4])+��ȣ�ص���(code[6]))*3+(��ȣ�ص���(code[1])+��ȣ�ص���(code[3])+��ȣ�ص���(code[5])+��ȣ�ص���(code[7]));
			
			if(result%10 == 0) {
				System.out.println("#"+t+" "+sum);
			}else {
				System.out.println("#"+t+" "+0);
			}
		}

	}

	
	static int ��ȣ�ص���(String code) {
		if(code.equals("0001101")) {
			return 0;	
		}else if(code.equals("0011001")) {
			return 1;	
		}else if(code.equals("0010011")) {
			return 2;	
		}else if(code.equals("0111101")) {
			return 3;	
		}else if(code.equals("0100011")) {
			return 4;	
		}else if(code.equals("0110001")) {
			return 5;	
		}else if(code.equals("0101111")) {
			return 6;	
		}else if(code.equals("0111011")) {
			return 7;	
		}else if(code.equals("0110111")) {
			return 8;	
		}else if(code.equals("0001011")) {
			return 9;	
		}
		return 10;
			
	}
}
