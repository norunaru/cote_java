package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 n개 정수로 이루어진 수열
 연속된 몇 개 합중 가장 큰 합
 수는 한 개 이상
 수를 하나 제거 가능(제거안해도됨)
 
 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열
 수를 제거하지 않았을 때의 정답은 12+21인 33이 정답
 
 10 -4 3 1 5 6 -35 12 21 -1
 
 
 
 -35를 제거한다면, 수열은 10, -4, 3, 1, 5, 6, 12, 21, -1이 되고, 여기서 정답은 10-4+3+1+5+6+12+21인 54
 
 n <= 100000 
 O(n)에 처리
 
  dp
  현재 -1까지 누적값 vs 현재값을 dp에 저장


 */
public class 연속합2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		int[] dp = new int[N];
		int max;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken()); 
		}
		
		dp[0] = numbers[0];
		max = numbers[0];
		
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(numbers[i] + dp[i-1], numbers[i]);
			max = Math.max(max,  dp[i]);
		}
		
		System.out.println(max);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(dp));
		
		
			
		
	}
}
