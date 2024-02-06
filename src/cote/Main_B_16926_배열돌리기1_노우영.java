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
	static int[][] move = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static int y=0,x=0;
	static int ny, nx,temp;
	static int cnt=0;

	public static void main(String[] args) throws IOException {
		//		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		Scanner s = new Scanner(System.in);

		int row = s.nextInt();
		int col = s.nextInt();
		int rotate = s.nextInt();

		arr = new int[row][col];
		visited = new boolean[row][col];

		for(int i=0; i<row; i++) { //배열 생성
			for(int j=0; j<col; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		temp = arr[y][x]; //
		System.out.println("temp : " +temp); //

		while(true) {
			cnt++;
			if(cnt==row*col)break;
			

			if(dir==0) { //우
				ny = y + move[0][0];
				nx = x + move[0][1];
				if(nx>=row ||visited[ny][nx] == true) dir++; //경계거나 방문했던 곳이면 방향 바꿈
				else {
					arr[y][x] = arr[ny][nx];
					visited[y][x] = true;
					y=ny;
					x=nx;
				}
			} else if(dir==1) { //하
				ny = y + move[1][0];
				nx = x + move[1][1];
				if(ny>=col ||visited[ny][nx] == true) dir++;
				else {
					arr[y][x] = arr[ny][nx]; //뒤 값을 가져옴
					visited[y][x] = true;
					y=ny;
					x=nx;
				}
			} else if(dir==2 ) { //좌
				ny = y + move[2][0];
				nx = x + move[2][1];
				if(nx<0 ||visited[ny][nx] == true) dir++;
				else {
					arr[y][x] = arr[ny][nx];
					visited[y][x] = true;
					y=ny;
					x=nx;
				}
			} else if(dir==3) { //상
				ny = y + move[3][0];
				nx = x + move[3][1];

				if(ny<0 ||visited[ny][nx] == true) {
					dir++;
				}
				else {
					arr[y][x] = arr[ny][nx]; 
					visited[y][x] = true;
					y=ny;
					x=nx;
				}
			}
			dir = dir%4;
		}//while

		for(int i=0; i<row; i++) { 
				System.out.println(Arrays.toString(arr[i]));
			
		}
		


	}//main
}