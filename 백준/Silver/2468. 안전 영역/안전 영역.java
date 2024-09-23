import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 어떤 지역의 높이 정보 파악
 지역에 비가 내렸을 때 물에 잠기지 않는 안전 영역이 최대 몇 개 만들어지는지 조사
 일정 높이 이하의 모든 지점은 물에 잠긴다고 가정 
 안전 영역  상하좌우 인접하며 크기가 최대인 영역
 
 
 조건
 n*n, 2<=n<=100
 배열의 각 원소는 높이, 1<=높이<=100
 높이가 4일 경우 4만큼 비가 내리면 잠긴것으로 처리
 
 로직
 1. 배열 만들고 높이 입력
 2. 비 내린 값 이하의 칸들은 0으로 처리
 3. 이차원배열 순회
 4. 0아닌 칸 있으면 bfs시작, cnt++
 5. 큐에 해당 칸 담고 0으로 수정 
 6. 해당 칸부터 상하좌우 검사, 0아닌칸 있으면 큐에 담고 bfs작업 반복
 7. 결과적으로 0이 아니었던 연결된 칸들은 0으로 됨
 
입력
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7

출력
5
 */
public class Main {
	static int[][] arr;
	static int[][] arr2;
	static int N;
	static int cnt = 0;
	static int maxHeight = 0; //건물 최대 높이
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	
	static Queue<Node> queue = new ArrayDeque<Node>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] > maxHeight) maxHeight = arr[y][x];
			}
		}
		
		for(int h=1; h<maxHeight; h++) {
			checkSafety(h);
		}
		
		if(cnt==0) cnt = 1;
		System.out.println(cnt);
		
//		print();
		
	}//main

	private static void checkSafety(int h) {
		int tempCnt = 0;
		arr2 = new int[N][N];
		
		//복사 배열 생성, 안전한 칸만 숫자 입력
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(arr[y][x] > h) arr2[y][x] = arr[y][x];
			}
		}
		
		//bfs 시작, 매 칸 순회하며 0아닌칸 찾기
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				
				if(arr2[y][x] != 0) {
					tempCnt++;
					
					//0으로 바꾸고 큐에 넣기
					arr2[y][x] = 0;
					queue.offer(new Node(y, x));
					
					while(!queue.isEmpty()) {
						Node cur = queue.poll();
						int cy = cur.y;
						int cx = cur.x;
						
						for(int i=0; i<4; i++) {
							int ny = cy + dy[i];
							int nx = cx + dx[i];
							if(ny>=0 && ny<N && nx>=0 && nx<N && arr2[ny][nx]!=0) {
								arr2[ny][nx] = 0;
								queue.offer(new Node(ny,nx));
							}
						}
					}//bfs
				}
			}
		}
		if(tempCnt > cnt) cnt = tempCnt;
		
//		for(int y=0; y<N; y++) {
//			System.out.println(Arrays.toString(arr2[y]));
//		}
//		System.out.println();
		
	}
	
	private static void print() {
		for(int y=0; y<N; y++) {
			System.out.println(Arrays.toString(arr[y]));
		}
		System.out.println(maxHeight);
	}
	
	//bfs용 클래스
	 static class Node {
		int y;
		int x;
		
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}