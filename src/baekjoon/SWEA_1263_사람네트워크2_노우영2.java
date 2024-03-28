package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 가중치 X -> bfs?
 각 노드마다 visit, cnt배열 만들기
 
 */
public class SWEA_1263_사람네트워크2_노우영2 {
//	static Queue<Integer> queue = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			
			//인접행렬만들기
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
					if(arr[y][x] == 0) arr[y][x] = 999;
				}
			}
		
			for(int i=0; i<n; i++) {
				arr[i][i] = 0;
			}
		
			
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
							arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
					}
				}
			}
			
			
			int[] cnt = new int[n];
			
			for(int i=0; i<n; i++) {
				int temp = 0;
				for(int j=0; j<n; j++) {
					temp+=arr[i][j];
				}
				cnt[i] = temp;
			}
			
			
			int result = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				if(cnt[i]<result)result = cnt[i];
			}
			System.out.println("#"+tc+" "+result);
			
		}//tc
	}//main

}
