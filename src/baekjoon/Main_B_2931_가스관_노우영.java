package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 11496	80
 */

public class Main_B_2931_가스관_노우영 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//정답 좌표 변수
		int Y=0;
		int X=0;
		
		//중간중간 빈칸 삽입
		char[][] arr = new char[R+R-1][C+C-1];
		char result='#';
		
		//arr채우기
		for(int i=0; i<R; i++) {
			String row = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i*2][j*2] = row.charAt(j);
				if(arr[i*2][j*2]=='|') {
					arr[i*2-1][j*2]='#';
					arr[i*2+1][j*2]='#';
				}else if(arr[i*2][j*2]=='-'){
					arr[i*2][j*2-1]='#';
					arr[i*2][j*2+1]='#';
				}else if(arr[i*2][j*2]=='+'){
					arr[i*2-1][j*2]='#';//상
					arr[i*2+1][j*2]='#';//하
					arr[i*2][j*2-1]='#';//좌
					arr[i*2][j*2+1]='#';//우
				}else if(arr[i*2][j*2]=='1'){
					arr[i*2+1][j*2]='#';//하
					arr[i*2][j*2+1]='#';//우
				}else if(arr[i*2][j*2]=='2'){
					arr[i*2-1][j*2]='#';//상
					arr[i*2][j*2+1]='#';//우
				}else if(arr[i*2][j*2]=='3'){
					arr[i*2-1][j*2]='#';//상
					arr[i*2][j*2-1]='#';//좌
				}else if(arr[i*2][j*2]=='4'){
					arr[i*2][j*2-1]='#';//좌
					arr[i*2+1][j*2]='#';//하
				}
			}
		}
		
//		for(int i=0; i<2*R-1; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		A:for(int y=0; y<2*R-1; y++) {
			for(int x=0; x<2*C-1; x++) {
				if(arr[y][x] == '.') {
					//.찾았으면 상하좌우 변수 만들고 주변의 #에 따라 결과 다르게
					boolean top=false;
					boolean bottom=false;
					boolean left=false;
					boolean right=false;
					
					if(y-1>=0 && arr[y-1][x]=='#') top=true;
					if(y+1<2*R-1 && arr[y+1][x]=='#') bottom=true;
					if(x-1>=0 && arr[y][x-1]=='#') left=true;
					if(x+1<2*C-1 && arr[y][x+1]=='#') right=true; 
					
					
					if(top&&bottom&&left&&right) {
						result = '+';
						Y=y/2;
						X=x/2;
						break A;
					}
					if(top && bottom) {
						result = '|';
						Y=y/2;
						X=x/2;
						break A;
					} if(left && right) {
						result = '-';
						Y=y/2;
						X=x/2;
						break A;
					} if(bottom && right) {
						result = '1';
						Y=y/2;
						X=x/2;
						break A;
					} if(top && right) {
						result = '2';
						Y=y/2;
						X=x/2;
						break A;
					} if(left && top) {
						result = '3';
						Y=y/2;
						X=x/2;
						break A;
					} if(left && bottom) {
						result = '4';
						Y=y/2;
						X=x/2;
						break A;
					} 
					
				}
				else {//.아니면 생략
					continue;
				}
			}
		}
		System.out.println(Y+1+" "+(X+1)+" "+result);
	}
}
