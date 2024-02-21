package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 메모리 14264kb
 * 시간 120ms
 */
public class Main_B_2636_치즈_노우영 {
	static int row,col;
	static int[][] arr;
	static int time;
	static boolean[][] visited;

	static Queue<Node> queue = new ArrayDeque<>();
	static List<Node> list;

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];

		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt;//나중에 이거로 time-1때 개수 출력
		int temp=0;
		
		while(true) {
			cnt=0;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(arr[i][j]==1) cnt++;
				}
			}
			if(cnt==0) break;
			bfs(0,0);
//			for(int i=0; i<row; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
//			System.out.println();
			temp = cnt;
		}
		System.out.println(time);
		System.out.println(temp);

	}//main
	
	//bfs돌리면 0,0과 연결된 모든 0들에 대해 4방탐색, 1이 나오면 1위치값 저장, 1 위치들 다 저장했으면 그 위치값들 0으로 수정
	private static void bfs(int y, int x) {
		//1하나라도 있으면 bfs수행
		visited = new boolean[row][col];
		time++;

		if(arr[y][x] == 0) {
			queue.offer(new Node(y,x));
		}

		list = new ArrayList<>();
		while(!queue.isEmpty()) {
			Node current = queue.poll();

			for(int i=0; i<4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];
				if(ny>=0 && ny<row && nx>=0 && nx<col && arr[ny][nx]==0 && visited[ny][nx]==false) {
					visited[ny][nx] = true;
					queue.offer(new Node(ny,nx));
				}
				else if(ny>=0 && ny<row && nx>=0 && nx<col && arr[ny][nx] == 1){
					list.add(new Node(ny,nx));
				}else continue;
			}
		}
		for(Node cur : list) {
			arr[cur.y][cur.x] = 0;
		}

	}//bfs

	static class Node{
		int y;
		int x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}