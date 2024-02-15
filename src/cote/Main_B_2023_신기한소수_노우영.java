package cote;

import java.util.Arrays;
import java.util.Scanner;

/*
 길이 N숫자 -> 앞에서부터 1자리,2자리,...,N자리가 모두 소수인 숫자 모두 찾기
 맨 앞자리 4,6,8,9 나오면 패스
 
 */
public class Main_B_2023_신기한소수_노우영 {
	static int N;
	static int[] number;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		number= new int[N];
		
		sosu(0);
		
	}//main
	
	private static void sosu(int cnt) {
		if(cnt==N) {
			StringBuilder sb = new StringBuilder();
			for(int a=0; a<cnt; a++) {
				sb.append(number[a]);
			}
			int currentNum = Integer.parseInt(sb.toString());
			int divCnt=0;
			for(int b=1; b<=currentNum;b++) {
				if(currentNum%b==0)divCnt++;
				if(divCnt>2) break;
			}
			if(divCnt<=2) {
				System.out.println(sb);
				return;
			}else return;
//			System.out.println(Arrays.toString(number));
//			return;
		}
		
		//자리수 다 못채웠으면
		if(cnt==0) { //첫자리면 0 못들어감
			for(int i=2; i<9; i++) {
				if(i==4 || i==6 || i==8 || i==9) continue;
				number[cnt] = i;
				sosu(cnt+1);
			}
		}else {//자리수 늘릴 때마다 현재까지 넣은 숫자들에 대해 소수인지 판정, 아니면 생략
			for(int i=0; i<10; i++) {
				number[cnt] = i;
				StringBuilder sb = new StringBuilder();
				for(int a=0; a<cnt; a++) {
					sb.append(number[a]);
				}
				int currentNum = Integer.parseInt(sb.toString());
//				System.out.println("current:"+currentNum);
				int divCnt=0;
				for(int b=1; b<=currentNum;b++) {
					if(currentNum%b==0)divCnt++;
					if(divCnt>2) break;
				}
				if(divCnt<=2) {
					sosu(cnt+1);
				}else continue;
				//여기까지 왔으면 아직은 소수
				
			}
		}
		
		
		
	}
}
