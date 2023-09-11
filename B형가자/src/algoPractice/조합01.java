package algoPractice;
package �˰�ǽ�;

import java.util.Arrays;

public class ����01 {
	public static String[] ���� = {"����", "��Ƽ", "�丶��", "ġ��","����"};
	public static int N = 5;
	public static int R = 2;
	public static String[] sel = new String[R];
	public static void main(String[] args) {
		
	}
	
	
	//idx : ������ index
	//sidx ; sel�� index
	public static void combination(int idx, int sidx) {
		//������Ʈ
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) return;
		
		//�����Ʈ
		sel[sidx] = ����[idx]; //�ش� ��� �־��
		combination(idx+1, sidx+1);// idx��° ��� ������
		combination(idx+1, sidx); //idx��° ��� �Ȼ�����
		
	}

}
