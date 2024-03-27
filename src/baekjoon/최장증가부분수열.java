package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] numbers = new int[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n=1; n<N+1; n++) {
				numbers[n] = Integer.parseInt(st.nextToken()); // [0,?,?,?,...,?] N+1개, 숫자는 N개
			}
			//======================================================
			int[] LIS = new int[N+1]; 
			
			
			//LIS 채우기, 첫자리는 0, 1~N인덱스까지 처리, 처리하는 숫자부터 인덱스 역으로 탐색, 현재 숫자보다 작은 숫자의 LIS값 찾고 비교
			for(int cur=1; cur<N+1; cur++) { //cur = 현재 원소가 위치하는 인덱스, 여기부터 반대로 보면서 작은값찾기
				int curVal = numbers[cur];
				
				for(int fore=cur-1; fore>=0; fore--) { //fore = 현재 원소보다 이전에 나왔던 원소의 인덱스
					int foreVal = numbers[fore];
					if(foreVal<curVal && LIS[fore]+1 > LIS[cur]) {
						LIS[cur] = LIS[fore]+1;
					}
				}
			}
			
			int maxLen = 0;
			for(int i=1; i<N+1; i++) {
				if(LIS[i]>maxLen) maxLen = LIS[i];
			}
			
			
			
			System.out.println("#"+tc+" "+maxLen);
		}
		
	}

}
