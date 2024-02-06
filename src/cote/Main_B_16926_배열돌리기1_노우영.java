package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/* temp
 * 1 2 3 4
 * 5 6 7 8
 * 9 8 7 6
 * 5 4 3 2
 */

public class Main_B_16926_배열돌리기1_노우영 {
	static int[][] arr;
	static boolean[][] visited;

	static int dir=0; //0=우 1=하 2=좌 3=상
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	
	static int y,x,row,col,r;
	static int ny, nx,temp,boxNum;
	static int cnt=0;

	public static void main(String[] args) throws IOException {
		//		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		boxNum = Math.min(row, col)/2;
		arr = new int[row+1][col+1];

		for(int i=1; i<row+1; i++) { //배열 생성
			st = new StringTokenizer(b.readLine());
			for(int j=1; j<col+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<row+1; i++) { //확인용 출력
//			for(int j=0; j<col+1; j++) {
//				System.out.print(arr[i][j]+ " ");
//			}System.out.println();
//		}
		for(int i=0; i<r; i++) {
			Rotate();	
		}
		
		for(int i=1; i<row+1; i++) { //확인용 출력
			for(int j=1; j<col+1; j++) {
				System.out.print(arr[i][j]+ " ");
			}System.out.println();
		}
	

	
	}//main
	private static void Rotate() {
		for(int i=1; i<=boxNum; i++) { //박스 개수만큼 반복
//			System.out.println(i);
			int dir=0;
			int corner = i; //다루는 박스 안쪽박스로 달라짐
			temp = arr[corner][corner]; //덮어 씌우므로 동작 전 미리 저장
			y = corner;
			x = corner;
			while(dir<4) { //dir이 4면 4방향 다 돈 것이므로 종료
				
				ny = y + dy[dir];
				nx = x + dx[dir];
//				System.out.println(ny+ " " + nx);
				if(ny>=corner && ny<=row+1-corner && nx>=corner && nx<=col+1-corner) {
					arr[y][x] = arr[ny][nx];
					y=ny;
					x=nx;
				} else dir++;
				
			}//while
			arr[corner+1][corner] = temp;
		}
	}
	
}