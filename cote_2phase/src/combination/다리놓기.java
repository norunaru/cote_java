package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 강 서쪽에 N개, 동쪽에 M개 0 <= N,M <= 30
 
 
 입력:
 테케 T
 각 테케마다 N,M주어짐
 
 */

public class 다리놓기 {
	static int T,N,R;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			result = 0;
			
			comb(0,0);
			System.out.println(result);
		}
			
	}//main
	
	static void comb(int cnt, int start) {
		if(cnt == R) {
			result++;
			return;
		}
		
		for(int i=start; i<N; i++) {
			comb(cnt+1, i+1);
		}
		
	}//comb
}





























