package algoPractice;
package �˰�ǽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class �鸸������������2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = str.length;
		int[] nums = new int[N];
		
		for(int i = 0 ; i<N; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(nums);
		System.out.println(nums);
		
	}
	
	private static void mergeSort(int[] arr, int left, int right){
		if(left<right) { // ������ ���̰� 2�̻��̸�
			
			int mid = (left+right)/2;
			
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			merge(arr,left,mid,right);
			
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		//arr�� �״�� �ΰ�
		//��ĥ ������ ���纻�� �����ΰ�
		//���ʹ迭 -> L / ���� �迭�� ���� -> n1
		//������ �迭 -> R / ������ �迭�� ���� -> n2
		//��ġ�鼭 arr�� �����.
		
		int lLength = mid -left +1;
		int rLength = right - mid;
		
		int[] lside = new int[lLength];
		int[] rside = new int[rLength];
		
		for(int i = 0; i<lLength; i++) {
			lside[i] = arr[left+i];
		}
		for(int i = 0; i<rLength; i++) {
			rside[i] = arr[mid+1+i];
		}
		
		//L�� R�� ��ġ�鼭 arr�� �����.
		int i=0; //L�� ���� ���� ���� ����Ű�� �ε���
		int j=0; //R
		int k=left; //arr�� ��ĥ �κ��� ���� ���� ���� ����Ű�� �ε���
		
		//���� �ʿ䰡 �ִ� ���
		while(i<lLength && j<rLength) {
			if(lside[i] < rside[j]) {
				arr[k++] = lside[i++]; //L�� �ű��.
			}
			else {
				arr[k++] = rside[j++];
			}
		}
		
		
		//�ű�⸸ �ϸ� �Ǵ� ���
		for(; i<lLength; i++) {
			arr[k++] = lside[i];
		}
		
		for(; j<rLength; j++) {
			arr[k++] = rside[j];
		}
	}
	

}
