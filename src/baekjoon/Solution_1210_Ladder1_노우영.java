package baekjoon;
import java.util.Scanner;

public class Solution_1210_Ladder1_노우영 {
	static int side = 100;
	static int[][]arr;
	
	public static void main(String[] args) {		
		Scanner s = new Scanner(System.in);
		
		
		for(int tc=1; tc<11; tc++) {
			int T = s.nextInt();
			int result;
			arr = new int[side][side];
			//사다리 만들기
			for(int y=0; y<side;y++) {
				for(int x=0; x<side; x++) {
					arr[y][x] = s.nextInt();
				}
			}
			
			//맨 아래 줄에서 2 찾아 역으로 탐색
			for(int x=0; x<side; x++) {
				
				int y = 99;
				if(arr[y][x] == 2) {
//					System.out.println(x);
					result = Recursive(y,x); 
					System.out.println("#"+tc + " " + result);
//					break;
				}
			}
			
			
		}
		
	}//main

	private static int Recursive(int y, int x) {
		if(y == 0) {
			return x;
		}
		//x=0이면 오른쪽만 확인
		if(x==0) {
			if(arr[y][x+1] == 1) {
				while(x != 99 && arr[y][x+1] == 1  ) {
					x += 1;
				}
				x = Recursive(y-1,x);
			}else {
				x =Recursive(y-1,x);
			}
		}
		//x=99면 왼쪽만 확인
		else if(x==99) {
//			System.out.println(y +" "+x);
			if(arr[y][x-1]==1) {
				while(x != 0 && arr[y][x-1] == 1) {
					x -= 1;
				}
				x =Recursive(y-1,x);
			} else {
				x =Recursive(y-1,x);
			}
		}
		//중간이면 양쪽 확인
		else {
			if(arr[y][x-1] == 1) { //왼쪽이 1이면
				while(x != 0 && arr[y][x-1] == 1) {
					x -= 1;
				}
				x = Recursive(y-1,x);
			} else if(arr[y][x+1] == 1) { //오른쪽이 1이면 
				while(x != 99 && arr[y][x+1] == 1) { //오른쪽으로 가다가 경로 밖일 수도 있음
					x += 1;
				}
				x =Recursive(y-1,x);
 			} else {                 //양쪽 다 0
				x =Recursive(y-1,x);
			}
		}	
		return x;
	}
}