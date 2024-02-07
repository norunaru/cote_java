package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 방이 n*n식으로 존재, 각 방에는 1<= ? <=n^2이하 서로 다른 숫자
 * 상하좌우 다른 방으로 이동 가능, 다음 방이 현재 방보다 +1일 때만 가능
 * 
 */


//29,668 kb
//332 ms


public class Solution_1861_정사각형방_노우영 {
	static int[][] arr;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N, cnt,num,roomNo, roomCnt;
	static int nx,ny;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테케 수
		
		for(int tc=1; tc<=T; tc++) { 
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			roomNo = N*N+1;
			roomCnt = 0;
			//arr 생성, 값 할당
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			//인덱스마다 move실행
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//인덱스마다 초기화시켜준다
					num = arr[i][j];
					cnt = 1;
					move(i,j,num,cnt);
				}
			}
			
			System.out.println("#" + tc + " " + roomNo + " " + roomCnt);
		}//tc
		
		
		
	}//main
	
	private static void move(int y, int x, int current, int cnt) { // 좌표, 좌표, 시작 방의 숫자, 이동한 방 개수
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue; //범위 밖이면 생략
			
			if(arr[ny][nx] == current+1) {//다음 위치가 현재+1이면
				cnt += 1;//이동개수 증가
				move(ny,nx,current+1,cnt);
			}
		} 
		//사방 봤는데 다음 방이 없으면 리턴
		if(roomCnt==cnt) { //저장된 값과 현재 계산한 값이 같으면
			if(num<roomNo) { 
				roomNo = num; //더 작은 값으로 교체
			}
		} else if(roomCnt<cnt) { //이번에 계산한 값이 더 크면
			roomCnt = cnt; //값 변경
			roomNo = num;
		}
		
		return;
	}//move
	
}




