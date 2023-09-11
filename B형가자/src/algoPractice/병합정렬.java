package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class �������� {
	//boj 2750
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//arr�� ���� �������� ����
		//�������� : �̹� ���ĵ� �� �迭�� ���ļ� �ϳ��� ���ĵ� �迭�� ����� ���� ����.
		//���̰� 1�϶����� ������
		//���ļ� �ö󰡱�
		mergeSort(arr, 0, N-1);
		
		//���پ� ���
		//��Ƽ� ���
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void mergeSort(int[]arr, int l, int r) {
		//l : ���� ������ ���� �� �ε���
		//r : ���� ������ ������ �� �ε���
		
		if(l < r) { //���� ������ ũ�Ⱑ 2 �̻� -> �ɰ� �� �ִ�.
			
			//�� �������� �ɰ���
			int m = (l+r)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			//��ģ��
			merge(arr, l, m, r);
		}
	}
	
	public static void merge(int[]arr, int l, int m, int r) {
		//arr�� �״�� �ΰ�
		//��ĥ ������ ���纻�� �����ΰ�
		//���ʹ迭 -> L / ���� �迭�� ���� -> n1
		//������ �迭 -> R / ������ �迭�� ���� -> n2
		//��ġ�鼭 arr�� �����.
		
		int n1 = m - l + 1; //l~m
		int n2 = r - m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		//���纻 �����
		for(int i=0; i<n1; i++) {
			L[i] = arr[l+i];
		}
		for(int j=0; j<n2; j++) {
			R[j] = arr[m+1 + j];
		}
		
		//L�� R�� ��ġ�鼭 arr�� �����.
		int i=0; //L�� ���� ���� ���� ����Ű�� �ε���
		int j=0; //R
		int k=l; //arr�� ��ĥ �κ��� ���� ���� ���� ����Ű�� �ε���
		
		//���� �ʿ䰡 �ִ� ���
		while(i<n1 && j<n2) {
			if(L[i] < R[j]) {
				arr[k++] = L[i++]; //L�� �ű��.
			}
			else {
				arr[k++] = R[j++];
			}
		}
		
		
		//�ű�⸸ �ϸ� �Ǵ� ���
		for(; i<n1; i++) {
			arr[k++] = L[i];
		}
		
		for(; j<n2; j++) {
			arr[k++] = R[j];
		}
		
		
	}
}

