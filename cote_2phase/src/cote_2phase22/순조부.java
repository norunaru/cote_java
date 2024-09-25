package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순조부 {
	static int N,R;
	static int[] numbers, result;
	static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		result = new int[R];
		isUsed = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		
		
		
	}//main
	
	static void perm(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isUsed[i] == false) {
				isUsed[i] = true;
				result[cnt] = numbers[i];
				perm(cnt+1);
				isUsed[i] = false;
			}
		}
	}//perm
	
	static void comb(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[cnt] = numbers[i];
			comb(cnt+1, start+1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
