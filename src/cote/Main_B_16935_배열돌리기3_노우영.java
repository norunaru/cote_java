package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_16935_배열돌리기3_노우영 {
	static int[][] arr;
	static int[][] temp;
	static int[][] D1,D2,D3,D4,D_temp; //4분할배열
	static int N,M,R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		D1 = new int[N/2][M/2];
		D2 = new int[N/2][M/2];
		D3 = new int[N/2][M/2];
		D4 = new int[N/2][M/2];
		D_temp = new int[N/2][M/2];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		//원하는 회전 방법 입력
		for(int i=0; i<R; i++) {
			int rotate = Integer.parseInt(st.nextToken());
			switch(rotate) {
				case 1:
					R1();
					break;
				case 2:
					R2();
					break;
				case 3:
					R3();
					break;
				case 4:
					R4();
					break;
				case 5:
					R5();
					break;
				case 6:
					R6();
					break;
			}
		}

		print(arr);


	}//main 

	private static void R1() { //상하 반전
		int rows = arr.length;
		int cols = arr[0].length;
		temp = new int[rows][cols];
		
		for(int i=0; i<rows; i++) {
			temp[rows-i-1] = arr[i];
		}
		arr = new int[rows][cols];
		arr = temp;
	}

	private static void R2() { //좌우 반전
		int rows = arr.length;
		int cols = arr[0].length;
		temp = new int[rows][cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				temp[i][j] = arr[i][cols-1-j];
			}
		}
		arr = new int[rows][cols];
		arr = temp;
	}

	private static void R3() { //오른쪽으로 90도 회전
		int rows = arr.length;
		int cols = arr[0].length;
		temp = new int[cols][rows];

		for(int i=0; i<rows; i++) { 
			for(int j=0; j<cols; j++) { 
				temp[j][rows-1-i] = arr[i][j];
			}
		}

		arr = new int[cols][rows];
		arr = temp; 
	}

	private static void R4() { //왼쪽으로 90도 회전
		int rows = arr.length;
		int cols = arr[0].length;
		temp = new int[cols][rows];

		for(int i=0; i<rows; i++) { //0-6
			for(int j=0; j<cols; j++) { //0~8
				temp[j][i] = arr[i][cols-1-j];
			}
		}
		arr = new int[cols][rows];
		arr = temp; 
	}

	private static void R5() {
		int rows = arr.length;
		int cols = arr[0].length;
		temp = new int[rows][cols];

		//4분할배열 생성
		for(int i=0; i<rows/2; i++) { //6  N
			for(int j=0; j<cols/2; j++) { //8  M
				D1[i][j] = arr[i][j]; //왼 위
				D2[i][j] = arr[i][cols/2+j]; //오른 위
				D3[i][j] = arr[i+rows/2][j+cols/2]; //오른 아래
				D4[i][j] = arr[i+rows/2][j];//왼 아래
			}
		}
		//4분할배열 temp에 저장
		for(int i=0; i<rows/2; i++) { //6  N
			for(int j=0; j<cols/2; j++) { //8  M
				temp[i][j] = D4[i][j]; //4->1
				temp[i][j+cols/2] = D1[i][j]; //1->2
				temp[rows/2+i][cols/2+j] = D2[i][j]; //2->3
				temp[rows/2+i][j] = D3[i][j];
			}
		}
		arr = new int[rows][cols];
		arr = temp;
	}

	private static void R6() {
		int rows = arr.length;
		int cols = arr[0].length;
		temp = new int[rows][cols];
		
		//4분할배열 생성
		for(int i=0; i<rows/2; i++) { //6  N
			for(int j=0; j<cols/2; j++) { //8  M
				D1[i][j] = arr[i][j]; //왼 위
				D2[i][j] = arr[i][cols/2+j]; //오른 위
				D3[i][j] = arr[i+rows/2][j+cols/2]; //오른 아래
				D4[i][j] = arr[i+rows/2][j];//왼 아래
			}
		}
		//4분할배열 temp에 저장
		for(int i=0; i<rows/2; i++) { //6  N
			for(int j=0; j<cols/2; j++) { //8  M
				temp[rows/2+i][j]  = D1[i][j]; //1->4
				temp[rows/2+i][cols/2+j] = D4[i][j]; //4->3  
				temp[i][j+cols/2] = D3[i][j]; //3->2
				temp[i][j]= D2[i][j]; //2->1
			}
		}
		arr = new int[rows][cols];
		arr = temp;
	}

	private static void print(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}