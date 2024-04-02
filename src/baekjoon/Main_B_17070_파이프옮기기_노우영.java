package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 가로 세로 대각
 
 밀어서 회전 가능
 회전은 45도만 가능
 미는 방향은 오른쪽, 아래, 오른아래대각
 ============================================
 재귀
 
 현재 상태(가로, 세로, 대각)에 따라 분기
 대각이면 이동 위치 + 주변 칸 2개 1인지 검사
 
 13872	220
 */
public class Main_B_17070_파이프옮기기_노우영 {
	static int status = 0; //가로 0 세로 1 대각 2
	static int N;
	static int result=0;
	static int[][] arr;
	
	static int[] garoY = {0,1};
	static int[] garoX = {1,1};
	
	static int[] seroY = {1,1};
	static int[] seroX = {0,1};
	
	static int[] daegakY = {0,1,1};
	static int[] daegakX = {1,0,1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//==========================================================
		move(0,0,1);
		System.out.println(result);
	}
	private static void move(int status, int y, int x) {
		if(y==N-1 && x==N-1) {
			result++;
			return;
		}
		//=============================================
		int ny,nx;
		if(status==0) { //가로면
			for(int i=0; i<2; i++) {
				ny = y + garoY[i];
				nx = x + garoX[i];
				//범위체크
				if(ny>=0 && ny<N && nx>=0 && nx<N) {
					if(i==0 && arr[ny][nx] != 1) {//가로이동
						move(0,ny,nx);
					} else if(i==1 && arr[ny][nx] != 1 && arr[ny-1][nx] != 1 && arr[ny][nx-1] != 1) { //대각이동
						move(2,ny,nx);
					}
				}
				
			}
		}else if(status==1) {//세로
			for(int i=0; i<2; i++) {
				ny = y + seroY[i];
				nx = x + seroX[i];
				//범위체크
				if(ny>=0 && ny<N && nx>=0 && nx<N) {
					if(i==0 && arr[ny][nx] != 1) {//세로이동
						move(1,ny,nx);
					} else if(i==1 && arr[ny][nx] != 1 && arr[ny-1][nx] != 1 && arr[ny][nx-1] != 1) { //대각이동
						move(2,ny,nx);
					}
				}
			}
		}else if(status==2) {//대각
			for(int i=0; i<3; i++) {
				ny = y + daegakY[i];
				nx = x + daegakX[i];
				//범위체크
				if(ny>=0 && ny<N && nx>=0 && nx<N) {
					if(i==0 && arr[ny][nx] != 1) {//가로
						move(0,ny,nx);
					}else if(i==1 && arr[ny][nx] != 1) { //세로이동
						move(1,ny,nx);
					} else if(i==2 && arr[ny][nx] != 1 && arr[ny-1][nx] != 1 && arr[ny][nx-1] != 1) { //대각이동
						move(2,ny,nx);
					}
				}
			}
		}
		
		
		
	}
}
