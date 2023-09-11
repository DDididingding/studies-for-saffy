package algoPractice;
package �˰�ǽ�;

import java.util.Arrays;

public class �W���ı��� {
	public static void main(String[] args) {
		
		int[] arr= {8,14,2,15,6,10,17,1,4};
		
		int i = 0 ; // ������ ���� ��
		int pivot = arr[i];
		int j = arr.length; // ������ ������ ��(exclusive)
		// �� ������ �ſ� ū ������ �����ٰ� ����
		
		while(i<j) { //i�� j�� ��ȯ�� �ʿ䰡 �ִٸ�
			//i�� ���ʿ��� pivot���� ū ��
			//j�� �����ʿ������� pivot���� ū ��
			
			do i++;
			while(arr[i] <= pivot); //�۰ų� ���ٸ� ������Ų��
			// arr[i]�� pivot���� ū ��
			do j--;
			while(arr[j] > pivot); //pivot���� ũ�ٸ� ����.
			// arr[j]�� pivot���� �۰ų� ���� ��
			
			if(i<j) swap(arr, i, j);
		}
		
		//while���� ����Ǿ��ٴ� ���� ���� j<=i �λ�Ȳ
		//���ʿ��� pivot���� �۰ų� ���� ����
		//������ ���� pivot���� ū ���� ����
		//pivot = j
		swap(arr, 0 , j);
		System.out.println(Arrays.toString(arr));
		
		
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
