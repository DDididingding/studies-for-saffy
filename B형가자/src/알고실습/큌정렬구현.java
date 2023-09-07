package 알고실습;

import java.util.Arrays;

public class 큌정렬구현 {
	public static void main(String[] args) {
		
		int[] arr= {8,14,2,15,6,10,17,1,4};
		
		int i = 0 ; // 구간의 왼쪽 끝
		int pivot = arr[i];
		int j = arr.length; // 구간의 오른쪽 끝(exclusive)
		// 한 구간은 매우 큰 값으로 끝난다고 가정
		
		while(i<j) { //i와 j가 교환할 필요가 있다면
			//i는 왼쪽에서 pivot보다 큰 값
			//j는 오른쪽에서부터 pivot보다 큰 값
			
			do i++;
			while(arr[i] <= pivot); //작거나 같다면 증가시킨다
			// arr[i]는 pivot보다 큰 수
			do j--;
			while(arr[j] > pivot); //pivot보다 크다면 증가.
			// arr[j]는 pivot보다 작거나 같은 수
			
			if(i<j) swap(arr, i, j);
		}
		
		//while문이 종료되었다는 것은 현재 j<=i 인상황
		//왼쪽에는 pivot보다 작거나 같은 수가
		//오른쪽 에는 pivot보다 큰 수가 있음
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
