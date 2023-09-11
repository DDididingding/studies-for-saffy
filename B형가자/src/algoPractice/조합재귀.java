package algoPractice;
package �˰�ǽ�;

public class ������� {
	public static String[] ��� = {"����", "���", "��", "��ġ"};
	public static int N = 4;
	public static boolean[] sel = new boolean[N];
	
	public static void main(String[] args) {
		powerset(0);
	}
	
	public static void powerset (int idx) {
		//������Ʈ
		if(idx==N) {//��� ��Ḧ �� �Ǵ��ߴ�
			for(int i = 0 ; i<N; i++) {
				if(sel[i])
					System.out.print(���[i]);
			}
			System.out.println();
			return;
		}
		//�����Ʈ
		
			sel[idx] = true;
			powerset(idx+1);
			
			sel[idx] = false;
			powerset(idx+1);
		
	}

}
