package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_6808_규영이와인영이의카드게임_노우영 {
	static int[] A = new int[9]; //규영이 카드
	static int[] B = new int[9]; //인영이 카드
	static int[] B_perm = new int[9];	
	static boolean[] isSelected = new boolean[9];
	static boolean[] used = new boolean[19]; 
	static int  A_win, A_lose;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		for(int tc=1; tc<T+1; tc++) {
			A_win = 0;
		    A_lose = 0;
			for(int i=0; i<9; i++) {
				 int input = s.nextInt();
				 A[i] = input;
				 used[input] = true;
			}
			
			int a=0;
			for(int i=1; i<19; i++) {
				if(used[i] == true) continue;
				else { 
					B[a] = i;
					a++;
				}
			}
		
			perm(0);
//			System.out.println("A :" + Arrays.toString(A));
//			System.out.println("B :" + Arrays.toString(B));
			System.out.println("#" + tc+ " " + A_win + " " + A_lose);	
			Arrays.fill(used, false);
		}
	}//main
	
	
	private static void perm(int cnt) {
		if(cnt==9) {
			int A_score, B_score;
			A_score=0;
			B_score=0;
			for(int i=0; i<9; i++) {
				if(A[i]>B_perm[i]) A_score += A[i]+B_perm[i];
				else if(A[i]<B_perm[i]) B_score += A[i]+B_perm[i];
			}
			if(A_score>B_score) A_win++;
			else if(A_score<B_score) A_lose++;
			return;
		}
		for(int i=0; i<9; i++) {
			if(isSelected[i]==true) continue;
			B_perm[cnt] = B[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}	
	}
}
