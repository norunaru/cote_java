package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 가중치 X -> bfs?
 각 노드마다 visit, cnt배열 만들기
 
 */
public class SWEA_1263_사람네트워크2_노우영_레벨BFS {
	static Queue<Integer> queue = new ArrayDeque<>();
	
	
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
				}
			}
			
			int[] cnt = new int[n]; //각 사람의 CC값 저장
			
			//시작노드
			for(int p=0; p<n; p++) { //p = 사람 번호
				int tempCnt = 0;
				boolean[] isVisited = new boolean[n];
				
				queue.add(p);
				isVisited[p] = true;
				
				int lvl=1;
				while(!queue.isEmpty()) {
					int size = queue.size();
					//레벨 bfs
					while(size-- >0) {
						int start = queue.poll(); //시작노드
						for(int end=0; end<n; end++) {
							//간선이 있고 방문하지 않았으면 도착지 큐에 추가, 방문체크
							if(arr[start][end] == 1 && isVisited[end] == false) {
								queue.add(end);
								isVisited[end] = true;
								tempCnt+=lvl;
							}
						}
					}
					lvl++;
				}
				cnt[p] = tempCnt;
			}
			int result = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				if(cnt[i]<result) result = cnt[i];
			}
			System.out.println("#"+tc+" "+result);
			
		}//tc
	}//main

}
