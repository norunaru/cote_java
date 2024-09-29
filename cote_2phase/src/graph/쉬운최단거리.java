package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 지도에서 모든 지점에 대해 거리 계산
 가로, 세로만 이동 가능
 n*m, (2<=n<=1000, 2<=m<=1000)
  
 입력: 
 n m 
 n개줄에 숫자 m개 주어짐. (0은 갈 수 없는 땅, 1은 갈 수 있는 땅, 2는 목표지점.
 입력에서 2는 단 한개
 
 프로세스 :
 1. 배열 입력받으면서 목표지점 좌표 저장(startY,startX)
 2. Node 클래스 생성
 3. 목표지점부터 bfs, 정답용 ans배열 설정
 4. 0인 지점은 생략, 1인 지점이면 큐에 넣기
 5. 
 
 */

public class 쉬운최단거리 {
	static int N,M;
	static int[][] arr, ans;
	static boolean[][] isVisited;
	static int startY, startX;

	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static Queue<Node> queue = new ArrayDeque<Node>();
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		ans = new int[N][M];
		isVisited = new boolean[N][M];
		
		//배열 설정
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					startY = i;
					startX = j;
				}
			}
		}
		
		queue.offer(new Node(startY,startX,0));
		isVisited[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curY = cur.y;
			int curX = cur.x;
			int curDist = cur.dist;
			
			ans[curY][curX] = curDist;
			
			int ny, nx;
			
			//상하좌우 검사
			for(int i=0; i<4; i++) {
				ny = curY + dy[i];
				nx = curX + dx[i];
				if(ny>=0 && ny<N && nx>=0 && nx<M && isVisited[ny][nx]==false && arr[ny][nx]!=0) {
					isVisited[ny][nx] = true;
					queue.offer(new Node(ny,nx,curDist+1));
				}
			}
		}//while
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]!=0 && isVisited[i][j]==false) {
					ans[i][j] = -1;
				}
			}
		}
		
		
		print(ans);
		
		
	}//main
	
	static void print(int[][] arr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	
	static class Node{
		int y,x,dist;
		
		Node(int y, int x, int dist){
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
