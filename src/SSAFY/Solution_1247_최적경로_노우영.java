package SSAFY;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Solution_1247_최적경로_노우영 {
	static int[] company = new int[2];
	static int[] home = new int[2];
	static int[][] customers;
	static int N,sum,result;
	static boolean[] isSelected;
	static int[][] temp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(b.readLine());
		for(int tc=1; tc<=T; tc++) {
			result=1000000;
			N = Integer.parseInt(b.readLine()); //고객 수
			StringTokenizer st = new StringTokenizer(b.readLine());
			
			//테케마다 초기화
			customers = new int[N][2];
			temp = new int[N+2][];
			isSelected = new boolean[N];
			
			//y, x
			company[0] = Integer.parseInt(st.nextToken()); //company y
			company[1] = Integer.parseInt(st.nextToken()); 
			home[0] =  Integer.parseInt(st.nextToken()); //home y
			home[1] =  Integer.parseInt(st.nextToken());
			
			temp[0] = company;
//			System.out.println(temp[0][0] + " " + temp[0][1]);
			
			for(int i=0; i<N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			perm(1);
			temp[N+1] = home;
//			System.out.println(result);
			
			System.out.println("#"+tc+" "+result);
		}
		
	}//main
	
	public static void perm(int cnt) { //cnt - 몇 번째 고객 위치 
		if(cnt == N+1) {
			sum=0;
			
			temp[N+1] = home;
			for(int i=0; i<N+1; i++) {
				sum += Math.abs(temp[i][0]-temp[i+1][0]) + Math.abs(temp[i][1] - temp[i+1][1]);
			}
			if(sum < result) result = sum;
			return;
		}
		for(int i=0; i<N; i++) {  //i - customer배열의 인덱스
			if(isSelected[i] == true) continue;
			temp[cnt] = customers[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
		
	}
}