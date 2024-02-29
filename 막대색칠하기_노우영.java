package a0227;

import java.util.Scanner;

/*
 파랑 A 1
 노랑 B 1
 빨강 C 2
 
 1 - 2
 A
 B
 
 2 - 5
 AA
 AB
 BB
 BA
 C
 
 3 - 12
 AAA
 AAB
 ABA
 ABB
 BBA
 BBB
 BAA
 BAB
 AC
 BC
 CA
 CB
 
 4 - 29
 
 dp[i] = dp[i-1]*2 + dp[i-2]
 */
public class 막대색칠하기_노우영 {
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i=3; i<n+1;i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
