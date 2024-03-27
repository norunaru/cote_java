package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 R*C
 빈칸 .
 물 * 
 돌 X
 비버굴 D
 고슴도치 S

 레벨 bfs
 
 11768kb, 80ms
 */
public class Main_B_3055_탈출_노우영 {
	static int R,C;
	static char[][] arr;
	static Queue<Node> queue = new ArrayDeque<>();
	static int Y,X; //고슴도치 좌표
	static boolean[][] isVisited, GSDCvisited; //방문배열, 고슴도치방문배열
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag=false;
		int[] start = new int[2];
		int[] end = new int[2];

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		isVisited = new boolean[R][C];
		GSDCvisited= new boolean[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j]=='S') {
					Y = i; //시작인덱스
					X = j;
					GSDCvisited[Y][X] = true;
					arr[i][j] = '.';
				}else if(arr[i][j] == '*') {
					queue.offer(new Node(i,j,'*'));
					isVisited[i][j] = true;
				}
			}
		}
//		print();
		
		//배열 만들면서 물 나오면 큐에 다 넣고, 마지막으로 고슴도치 위치 넣고 시작
		queue.offer(new Node(Y, X,'g'));
		int depth = 0;
		
		
//==================================================================================================================
		//물 늘리고 비버 이동하고 물 늘리고 비버 이동하고 물 늘리고 비버 이동하고물 늘리고 비버 이동하고물 늘리고 비버 이동하고물 늘리고 비버 이동하고
		A:while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				Node cur = queue.poll();
				int curY = cur.y;
				int curX = cur.x;
				char Z = cur.z; //고슴도치인지 물인지 판별 물-*, 고슴도치-g
				
				if(Z == '*') { //물이면
					for(int dir=0; dir<4; dir++) {
						int ny = curY + dy[dir];
						int nx = curX + dx[dir];
						
						//범위 내, 땅, 방문한적 없으면 물로채움
						if(ny<R && ny>=0 && nx<C && nx>=0 && arr[ny][nx]=='.' && isVisited[ny][nx] == false){
							isVisited[ny][nx] = true;
							arr[ny][nx] = '*';
							queue.offer(new Node(ny,nx,'*'));
						}
					}
				}else if(Z == 'g') { //고슴도치면 
					for(int dir=0; dir<4; dir++) {
						int ny = curY + dy[dir];
						int nx = curX + dx[dir];
						
						//범위 내, 땅, 방문한적 없으면 물로채움
						if(ny<R && ny>=0 && nx<C && nx>=0){ 
							if(arr[ny][nx] == 'D') {//목적지면 종료
								flag = true;
								depth++;
								break A;
							}else if(arr[ny][nx] == '.' && GSDCvisited[ny][nx]==false) { //목적지가 아니고 땅이면 
								GSDCvisited[ny][nx] = true;
								queue.offer(new Node(ny,nx,'g'));
							}
						}
					}
				}
				
//				System.out.println();
//				print();
				
			}
			
			depth++;
		}

		if(flag) {
			System.out.println(depth);
		}else {
			System.out.println("KAKTUS");
		}

		
	}



















	static class Node {
		int y,x ;
		char z;
		Node(int y, int x, char z){
			this.y = y;
			this.x = x;
			this.z = z;
		}
	}



	private static void print() {
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
