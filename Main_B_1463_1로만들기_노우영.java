package a0227;

import java.util.Arrays;
import java.util.Scanner;

/*
 1. x%3==0 -> %3
 2. x%2==0 -> %2
 3. -1
 연산 사용하는 최소 횟수?
 10 9 3 1
 
 
 1<=N<=10^6
 
 현재 숫자가 3의 배수면 3으로 나눔
 
 3배수가 아니면 현재 숫자보다 작은 가장 가까운 3으로 나눠 떨어지는 숫자로 변경

 1 2 3 4 5 6 7 8 9 10
 0 1 1 2 3 2 3 3 2 3
 
  1. 만약 3의 배수 -> dp[i] = dp[i/3]+1
  2. 만약 2의 배수 -> n
  3. 둘 다 아님 -> dp[i] = dp[i-1] + 1
  4. 3의 배수이고 2의 배수 dp[i] = dp[i/3]+1
  
  */


public class Main_B_1463_1로만들기_노우영 {

	static int[] dp;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		dp = new int[n+5];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		
		for(int i=4; i<n+1; i++) {
			int a = dp[i-1]; //-1
			int b = dp[i/2]; // /2
			int c = dp[i/3]; // /3
			
			if(i%2==0 && i%3==0) {
				int min = Math.min(a, b);
				min = Math.min(min, c);
				dp[i] = min+1;
			}else if(i%3==0 && i%2!=0) {
				dp[i] = Math.min(c, a)+1;
			}else if(i%3!=0 && i%2==0) {
				dp[i] = Math.min(a, b)+1;
			}else {
				dp[i] = a+1;
			}
			
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}
