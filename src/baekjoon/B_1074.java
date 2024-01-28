package baekjoon;

import java.util.Scanner;

public class B_1074 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int row = s.nextInt();
		int col = s.nextInt();
		
		int result = Z(n,row,col);
		System.out.println(result);
		
	}
	
	public static int Z(int n, int row, int col) {
		if(n==0) return 0;
		int half = 1 * (int)Math.pow(2, n-1);
		
		if(row < half && col < half) return Z(n-1,row,col);
		if(row < half && col >= half) return half*half + Z(n-1, row, col-half);
		if(row >= half && col < half) return half*half*2 + Z(n-1,row-half, col);
		if(row >= half && col >= half) return half*half*3 + Z(n-1, row-half, col-half);
		
		
		
		
		return 0;
	}
}
