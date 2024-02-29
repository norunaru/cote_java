package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 나이트처럼 K번만 이동, 그 외에는 상하좌우만
 좌상단 -> 우하단
 최소한의 동작으로 시작 ~ 도착 방법

 K
 W,H


1
4 4
0 0 0 0
1 0 0 0
0 0 1 0
0 1 0 0

메모리 50100
시간 460
 */
public class Main_B_1600_말이되고픈원승이_노우영 {
	static int K,W,H;
	static int[][] arr;
	static boolean[][][] isVisited;
	static Queue<Node> queue = new ArrayDeque<>();
	static int[] dy = {-1,1,0,0,-1,-2,-2,-1,1,2,2,1}; //상 하 좌 우 + 나이트*8
	static int[] dx = {0,0,-1,1,-2,-1,1,2,2,1,-1,-2};
	static int k=0;
	static int depth;

	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); //대각 움직이는 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][W];
		isVisited = new boolean[H][W][K+1];

		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//bfs
		queue.offer(new Node(0,0,0));
		isVisited[0][0][0] = true;
		int depth = 0;

		A:while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				Node current = queue.poll();
				int curY = current.y;
				int curX = current.x;
				int k = current.k; //대각이동한 횟수

				if(curY == H-1 && curX == W-1) {
					flag = true;
					break A;
				}

				//상하좌우
				for(int dir=0; dir<4; dir++) {
					int ny = curY + dy[dir];
					int nx = curX + dx[dir];
					

					//경계 안나가고 방문 안했고 장애물 아니면 이동
					if(ny<H && ny>=0 && nx<W && nx>=0 && isVisited[ny][nx][k]==false && arr[ny][nx] == 0) {
						queue.offer(new Node(ny,nx,k));
						isVisited[ny][nx][k] = true;
					}
				}

				//대각이동 횟수가 없으면 생략
				if(k==K) continue;
				for(int dir=4; dir<12; dir++) {
					int ny = curY + dy[dir];
					int nx = curX + dx[dir];
					

					//경계 안나가고 방문 안했고 장애물 아니면 이동
					if(ny<H && ny>=0 && nx<W && nx>=0 && arr[ny][nx] == 0 && isVisited[ny][nx][k+1] == false) {
						queue.offer(new Node(ny,nx,k+1));
						isVisited[ny][nx][k+1] = true;
					}
				}
			}//레벨 bfs

			depth++;
		}

		if(flag==false) {
			System.out.println(-1);
		}else {
			System.out.println(depth);
		}

	}//main

	private static class Node{
		int y,x,k;

		Node(int y, int x, int k){
			this.y = y;
			this.x = x;
			this.k = k;
		}
	}

}
