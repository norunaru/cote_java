package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
/*
 메모리 12320kb
 시간 88ms
 
 */
public class Main_B_10026_적록색약_노우영_DFS {
	static char color1, color2;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N;
	static char[][] arr1;
	static char[][] arr2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr1 = new char[N][N];//정상인
		arr2 = new char[N][N];//색약
		
		int R1=0,G1=0,B1=0,R2=0,B2=0;
		int result1, result2;
		
		
		//배열만들기
		for(int i=0; i<N; i++) {
			String current = br.readLine();
			for(int j=0; j<N; j++) {
				arr1[i][j] = current.charAt(j);
				
				if(current.charAt(j)=='R' || current.charAt(j)=='G') {
					arr2[i][j] = 'R';
				}else {
					arr2[i][j] = current.charAt(j);
				}
			}
		}
		
		//입력 확인
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(arr1[i]));
//		}
//		System.out.println();
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(arr2[i]));
//		}
		
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr1[i][j]=='R' || arr1[i][j]=='G' || arr1[i][j]=='B') {
					if(arr1[i][j]=='R') R1++;
					else if(arr1[i][j]=='G') G1++;
					else if(arr1[i][j]=='B') B1++;
					
					
					dfs1(i,j,arr1[i][j]);
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr2[i][j]=='R' || arr2[i][j]=='B') {
					if(arr2[i][j]=='R') R2++;
					else if(arr2[i][j]=='B') B2++;
					
					dfs2(i,j,arr2[i][j]);
				}
			}
		}
		result1 = R1 + G1 + B1;
		result2 = R2 + B2;
		
		System.out.println(result1 +" " +result2 );
		
	}//main
	private static void dfs1(int y, int x, char color) {		
		//delta
		
		arr1[y][x] = 'A';
		for(int i=0; i<4; i++) {
			
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && ny<N && nx>=0 && nx<N && arr1[ny][nx]==color) { //범위 내, 같은 색이면
				dfs1(ny,nx,color);
				
			}
		}
	}
	
	private static void dfs2(int y, int x, char color) {		
		//delta
		
		arr2[y][x] = 'A';
		for(int i=0; i<4; i++) {
			
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && ny<N && nx>=0 && nx<N && arr2[ny][nx]==color) { //범위 내, 같은 색이면
				dfs2(ny,nx,color);
				
			}
		}
	}
	
	

}