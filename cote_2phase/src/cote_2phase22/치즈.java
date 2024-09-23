package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0

3
5

n*n 판에 치즈
 판의 가장자리는 치즈 x
 공기와 닿으면 놓음
 치즈 안에는 공기x, 녹아서 구멍 생기면 공기 들어감
 
 
 사각형 모양의 판 크기, 치즈 주어짐
 모두 녹는데 걸리는 시간, 모두 녹기 한시간 전에 치즈조각이 놓인 칸의 개수
 
 로직
 1. n*n배열 생성, 치즈자리는 1로 표시
 2. 각 행렬 칸 클래스 생성, delta 생성, prevChz = 입력하면서 0개수 저장, curChz변수 생성
 3. 이전 치즈개수가 0아니면 모든 칸 순회하며 curChz개수 설정, (0,0)부터 bfs -> 1인 칸 만나면 저장
 4. 저장된 칸 0으로 만들기
 5. prevChz를 curChz로, 다음 반복 시작
 
 */

public class 치즈 {
	static int[][] arr;
	static int N,M;
	static int ans, chz, time;
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static Queue<Node> queue = new ArrayDeque<Node>();
	static Queue<Node> queue2 = new ArrayDeque<Node>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) chz++;
			}
		}
//		print();
		while(chz != 0) {
			time++;
			
			//방문배열 생성
			boolean[][] isVisited = new boolean[N][M];
			
			queue.offer(new Node(0,0));
			isVisited[0][0] = true;
			
			//0,0부터 bfs
			while(!queue.isEmpty()) {
				Node cur = queue.poll();
				int y = cur.y;
				int x = cur.x;
				
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if(ny<N && ny>=0 && nx<M && nx>=0 && isVisited[ny][nx]==false && arr[ny][nx]==0) {
						isVisited[ny][nx] = true;
						queue.offer(new Node(ny,nx));
					}else if(ny<N && ny>=0 && nx<M && nx>=0 && isVisited[ny][nx]==false && arr[ny][nx]==1) {
						isVisited[ny][nx] = true;
						queue2.offer(new Node(ny,nx));
					}
				}
			}
			
			//공기와 닿는 치즈들 녹이기
			while(!queue2.isEmpty()) {
				Node cur = queue2.poll();
				int y = cur.y;
				int x = cur.x;
				arr[y][x] = 0;
			}
			ans = chz;
			//녹인 뒤 치즈 개수
			chz = 0;
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(arr[y][x] == 1) chz++;
				}
			}
		}
		System.out.println(time);
		System.out.println(ans);
		
	}//main
	
	private static void Melt() {
		
	}
	
	private static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	
	private static class Node{
		int y;
		int x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
















