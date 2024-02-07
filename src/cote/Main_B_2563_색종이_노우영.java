package cote;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 : 11748kb
//시간 : 76ms

public class Main_B_2563_색종이_노우영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		
		int num = Integer.parseInt(br.readLine()); //색종이 수
		
		for(int i=0; i<num; i++) { //색종이 수만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			
			for(int y=startY; y<startY+10; y++) { //입력받은 좌표부터 10*10영역을 1로 표시
				for(int x=startX; x<startX+10; x++){
					arr[y][x] = 1;
				}
			}
		
		}
		
		int sum=0;
		for(int i=0; i<100;i++) { //1로 표시된 영역의 수가 정답
			for(int j=0;j<100; j++) {
				if(arr[i][j]==1) sum++;
			}
		}
		System.out.println(sum);
		
		
		
	}//main

}