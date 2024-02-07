package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 1. 한 번에 계단 하나 or 두개
 * 2. 연속으로 계단 3개 X
 * 
 * 
 * 
 * */
public class 계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(b.readLine());
		int[] stairs = new int[n];
		//계단 생성
		for(int i=0; i<n; i++) {
			stairs[i] = Integer.parseInt(b.readLine());
		}
		
		
	}

}
