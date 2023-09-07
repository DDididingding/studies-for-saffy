package 알고실습;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 병합정렬 {
	//boj 2750
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//arr에 대해 병합정렬 수행
		//병합정렬 : 이미 정렬된 두 배열을 합쳐서 하나의 정렬된 배열로 만드는 것은 쉽다.
		//길이가 1일때까지 나누기
		//합쳐서 올라가기
		mergeSort(arr, 0, N-1);
		
		//한줄씩 출력
		//모아서 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void mergeSort(int[]arr, int l, int r) {
		//l : 현재 구간의 왼쪽 끝 인덱스
		//r : 현재 구간의 오른쪽 끝 인덱스
		
		if(l < r) { //현재 구간의 크기가 2 이상 -> 쪼갤 수 있다.
			
			//두 구간으로 쪼개고
			int m = (l+r)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			//합친다
			merge(arr, l, m, r);
		}
	}
	
	public static void merge(int[]arr, int l, int m, int r) {
		//arr은 그대로 두고
		//합칠 구간만 복사본을 만들어두고
		//왼쪽배열 -> L / 왼쪽 배열의 길이 -> n1
		//오른쪽 배열 -> R / 오른쪽 배열의 길이 -> n2
		//합치면서 arr에 덮어쓴다.
		
		int n1 = m - l + 1; //l~m
		int n2 = r - m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		//복사본 만들기
		for(int i=0; i<n1; i++) {
			L[i] = arr[l+i];
		}
		for(int j=0; j<n2; j++) {
			R[j] = arr[m+1 + j];
		}
		
		//L과 R을 합치면서 arr에 덮어쓴다.
		int i=0; //L의 가장 작은 값을 가리키는 인덱스
		int j=0; //R
		int k=l; //arr의 합칠 부분의 가장 작은 값을 가리키는 인덱스
		
		//비교할 필요가 있는 경우
		while(i<n1 && j<n2) {
			if(L[i] < R[j]) {
				arr[k++] = L[i++]; //L을 옮긴다.
			}
			else {
				arr[k++] = R[j++];
			}
		}
		
		
		//옮기기만 하면 되는 경우
		for(; i<n1; i++) {
			arr[k++] = L[i];
		}
		
		for(; j<n2; j++) {
			arr[k++] = R[j];
		}
		
		
	}
}

