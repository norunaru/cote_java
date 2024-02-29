package a0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 메모리 : 12100kb
 시간 : 92ms
 
 
 완탐으로 풀면 2^N의 시간이 걸림 -> 시간초과되므로 dp로 풀어야됨
 */

public class Main_B_1149_RGB거리_노우영 {
	static int N;
	static int R,G,B;
	static int[][] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		
		//arr[y][x]의 의미 : y번 건물을 x로 칠할 때의 비용
		//dp[y][x]의 의미 : y번 건물을 x로 칠했을 때의 누적 최소 결과값(이전 줄도 다 칠했음)
		
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr[i][0] = R;
			arr[i][1] = G;
			arr[i][2] = B;
		}
		//dp 테이블 첫줄은 그대로 사용
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}
		
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		
		System.out.println(min);
	}

}
