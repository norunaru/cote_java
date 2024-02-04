package baekjoon;
import java.util.Scanner;

public class Solution_5215_햄버거다이어트_노우영 {
	static int result,temp,currentMax, scoreSum, calSum;
	static int scores[];
	static int calories[];
	static int N,limit;
	static boolean isSelected[];
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		 
		for(int tc=1; tc<T+1; tc++) { //tc
			N = s.nextInt();
			limit = s.nextInt();
			
			scores = new int[N];
			calories = new int[N];
			isSelected = new boolean[N];
			scoreSum = 0;
			calSum = 0;
			currentMax = 0;
			result = 0;
			
			for(int i=0; i<N; i++) {
				scores[i] = s.nextInt();
				calories[i] = s.nextInt();
			}
			
			Subset(0);
			System.out.println("#"+tc+" "+result);
			
		}
		
		
		
	}
	private static void Subset(int cnt) { 
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					scoreSum+= scores[i];
					calSum+=calories[i];
				}
			}
			if(calSum<=limit && scoreSum>result ) {
				result = scoreSum;
			}
//			System.out.println(scoreSum);
			scoreSum = 0;
			calSum = 0;
			return;
		}
		
		isSelected[cnt] = true; //부분집합의 구성에 넣는 경우
		Subset(cnt+1);
		
		isSelected[cnt] = false; //부분집합에 포함하지 않는 경우
		Subset(cnt+1);
		
		
		
	}
	
	
	
	
	
}
