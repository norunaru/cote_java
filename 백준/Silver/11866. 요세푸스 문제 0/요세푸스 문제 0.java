import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 1~N번까지 N명이 원형으로 앉음
 양의 정수 K주어짐(<=N)
 순서대로 K번째 사람 제거
 한 사람 제거되면 남은 사람들로 원을 따라 과정 반복
 N명의 사람이 모두 제거될 때까지
 사람들이 제거되는 순서를 (N,K) - 요세푸스 순열
 (7,3) = 3,6,2,7,5,1,4
 1 2 3 4 5 6 7
 1 2 x 4 5 6 7 
 1 2 x 4 5 x 7
 1 x x 4 5 x 7
 1 x x 4 5 x x 
 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		int N,K;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[N];
		for(int i=0; i<N; i++) {
			numbers[i] = i+1;
		}
		
		boolean[] isUsed = new boolean[N];
		
		int cnt = 0;
		int idx = -1;
		
		while(cnt<N) {
			int temp=0;
			while(temp<K) {
				idx=(idx+1)%N;
				if(isUsed[idx]==false) temp++;
			}
			
			sb.append(numbers[idx]);
			isUsed[idx] = true;
			
			cnt++;
			if(cnt<N) {
				sb.append(", ");
			}
			
			
		}
		sb.append(">");
		System.out.println(sb);
		
	}//main

}