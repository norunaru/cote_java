package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
체스판 크기 n 주어짐
n주어질 때 퀸을 놓을 서로 공격 못하게 놓을 수 있는 방법은?
 
조건
1 <= n <= 15

로직
1. n행 n열 체스판 배열 생성
2. 8방 dy, dx생성
3. n*n checker 배열 생성, int형
4-1. 체스판 1행부터 검사
4-2. 1행 1열~1행 n열까지 놓으면서 검사
4-3. 한 행에 놨으면 다음 체커배열 1로 수정
4-4. 놓은 뒤 팔방 검사 공격가능하면 dfs중단
4-5. 놓아지면 다음 행에서 반복
5. n행까지 놨으면 dfs종료, cnt +1


*/
public class n퀸2 {
	static int[][] checker;
	
	static int result = 0;
	static int N;
	static int ny, nx;
	
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		checker = new int[N][N];
		
//		print();
		for(int x=0; x<N; x++) {
			checker = new int[N][N];
			
			setVisit(0,x,1);
			Queen(1);
			setVisit(0,x,-1);
		}
		System.out.println(result);
	}//main
	
	private static void Queen(int cnt) {
		if(cnt == N) {
			result++;
			return;
		}
		for(int x=0; x<N; x++) {
			if(checker[cnt][x] == 0) {
				setVisit(cnt, x, 1);
				Queen(cnt+1);
				setVisit(cnt,x,-1);
			}
		}
	}
	
	private static void setVisit(int y, int x, int val) {
		checker[y][x] += val;
		
		for(int i=0; i<8; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			
			while(ny<N && ny>=0 && nx<N && nx>=0) {
				checker[ny][nx] += val;
				ny = ny + dy[i];
				nx = nx + dx[i];
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	private static void print() {
		for(int y=0; y<N; y++) {
			System.out.println(Arrays.toString(checker[y]));
		}
	}
	
}
