package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백만개의정수정렬2 {
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
		if(left<right) { // 구간의 길이가 2이상이면
			
			int mid = (left+right)/2;
			
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			merge(arr,left,mid,right);
			
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		//arr은 그대로 두고
		//합칠 구간만 복사본을 만들어두고
		//왼쪽배열 -> L / 왼쪽 배열의 길이 -> n1
		//오른쪽 배열 -> R / 오른쪽 배열의 길이 -> n2
		//합치면서 arr에 덮어쓴다.
		
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
		
		//L과 R을 합치면서 arr에 덮어쓴다.
		int i=0; //L의 가장 작은 값을 가리키는 인덱스
		int j=0; //R
		int k=left; //arr의 합칠 부분의 가장 작은 값을 가리키는 인덱스
		
		//비교할 필요가 있는 경우
		while(i<lLength && j<rLength) {
			if(lside[i] < rside[j]) {
				arr[k++] = lside[i++]; //L을 옮긴다.
			}
			else {
				arr[k++] = rside[j++];
			}
		}
		
		
		//옮기기만 하면 되는 경우
		for(; i<lLength; i++) {
			arr[k++] = lside[i];
		}
		
		for(; j<rLength; j++) {
			arr[k++] = rside[j];
		}
	}
	

}
