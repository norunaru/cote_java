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

//
//package a0206;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//
///* temp
// * 1 2 3 4
// * 5 6 7 8
// * 9 8 7 6
// * 5 4 3 2
// */
//
//public class Main_B_16926_배열돌리기1_노우영 {
//	static int[][] arr;
//	static boolean[][] visited;
//
//	static int dir=0; //0=우 1=하 2=좌 3=상
//	static int[][] move = {{0,1}, {1,0}, {0,-1}, {-1,0}};
//	static int y=0,x=0;
//	static int ny, nx,temp;
//	static int cnt=0;
//
//	public static void main(String[] args) throws IOException {
//		//		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
//
//		StringBuilder sb = new StringBuilder();
//		Scanner s = new Scanner(System.in);
//
//		int row = s.nextInt();
//		int col = s.nextInt();
//		int rotate = s.nextInt();
//
//		arr = new int[row][col];
//		visited = new boolean[row][col];
//
//		for(int i=0; i<row; i++) { //배열 생성
//			for(int j=0; j<col; j++) {
//				arr[i][j] = s.nextInt();
//			}
//		}
//
//		temp = arr[y][x]; //
//		System.out.println("temp : " +temp); //
//
//		while(true) {
//			cnt++;
//			if(cnt==row*col)break;
//			
//
//			if(dir==0) { //우
//				ny = y + move[0][0];
//				nx = x + move[0][1];
//				if(nx>=row ||visited[ny][nx] == true) dir++; //경계거나 방문했던 곳이면 방향 바꿈
//				else {
//					arr[y][x] = arr[ny][nx];
//					visited[y][x] = true;
//					y=ny;
//					x=nx;
//				}
//			} else if(dir==1) { //하
//				ny = y + move[1][0];
//				nx = x + move[1][1];
//				if(ny>=col ||visited[ny][nx] == true) dir++;
//				else {
//					arr[y][x] = arr[ny][nx]; //뒤 값을 가져옴
//					visited[y][x] = true;
//					y=ny;
//					x=nx;
//				}
//			} else if(dir==2 ) { //좌
//				ny = y + move[2][0];
//				nx = x + move[2][1];
//				if(nx<0 ||visited[ny][nx] == true) dir++;
//				else {
//					arr[y][x] = arr[ny][nx];
//					visited[y][x] = true;
//					y=ny;
//					x=nx;
//				}
//			} else if(dir==3) { //상
//				ny = y + move[3][0];
//				nx = x + move[3][1];
//
//				if(ny<0 ||visited[ny][nx] == true) {
//					dir++;
//				}
//				else {
//					arr[y][x] = arr[ny][nx]; 
//					visited[y][x] = true;
//					y=ny;
//					x=nx;
//				}
//			}
//			dir = dir%4;
//		}//while
//
//		for(int i=0; i<row; i++) { 
//				System.out.println(Arrays.toString(arr[i]));
//			
//		}
//		
//
//
//	}//main
//}