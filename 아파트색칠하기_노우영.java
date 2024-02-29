package a0227;

import java.util.Scanner;

public class 아파트색칠하기_노우영 {

	static int[] dp;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 2;
		

		for(int i=2; i<n+1;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		System.out.println(dp[n]);
	}

}
