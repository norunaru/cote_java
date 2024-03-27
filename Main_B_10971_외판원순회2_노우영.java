package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 도시 1~N
 도시들 사이 길 존재(없을수도)
 한번 간 도시는 다시 못감
 가장 적은 비용 
 
 cost[i][j] != cost[j][i]
 가장 적은 비용을 들이는 경로는?
 
 0이면 길없음
 
 순열 || dfs
 
 13012kb, 420ms
 */
public class Main_B_10971_외판원순회2_노우영 {
	static int N;
	static int[][] arr;
	static int minVal = Integer.MAX_VALUE;
	static boolean[] isVisited;
	static int first, last;
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		
		//arr 채우기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//각 시작점으로 dfs
		for(int i=0; i<N; i++) {
			isVisited = new boolean[N];
			isVisited[i] = true;
			first = i;
			dfs(i, 0);
		}
		
		System.out.println(minVal);
		
	}//main
	
	
	private static void dfs(int start, int cnt) { //시작 정점, 누적 요금
		boolean flag = true;
		for(int i=0; i<N; i++) {
			if(isVisited[i]==false) { //방문 안한게 있으면
				flag = false;
			}
		}
		
		if(flag == true) { //도시들 다 방문했으면
			if(arr[start][first] != 0) {
				cnt += arr[start][first];
				minVal = Math.min(minVal, cnt);
			}
			return;
		}
		
		//================================================================
		
		//시작 행의 각 열에 대해 확인
		for(int x=0; x<N; x++) {
			if(arr[start][x]!=0 && isVisited[x]==false) { //도로가 있으면
				isVisited[x] = true;
				dfs(x,cnt+arr[start][x]);
				isVisited[x] = false;
			}
		}
		
//		System.out.println(Arrays.toString(isVisited));
		
		
	}
	
	
	
}
