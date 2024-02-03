package baekjoon;

import java.util.Scanner;

public class Solution_1954_달팽이숫자_노우영 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		for(int tc=1; tc<T+1; tc++) {
			int size = s.nextInt();

			int[][] snail = new int[size][size];

			snail[0][0] = 1;
			int y=0;
			int x=0;
			int flag = 0;
			int cnt = 1;

			while(cnt != size*size) {
				cnt += 1;
				if(flag%4 == 0) { //오른쪽
					x += 1;
					snail[y][x] = cnt;

					if(x+1==size || snail[y][x+1]!=0) flag += 1;
				} else if(flag%4 == 1) { //아래
					y += 1;
					snail[y][x] = cnt;

					if(y+1==size || snail[y+1][x]!=0) flag += 1;
				} else if(flag%4 == 2) { //왼
					x -= 1;
					snail[y][x] = cnt;

					if(x-1==-1 || snail[y][x-1]!=0) flag += 1;
				} else if(flag%4 == 3) { //위
					y -= 1;
					snail[y][x] = cnt;

					if(y-1==size || snail[y-1][x]!=0) flag += 1;
				}
			}

			System.out.println("#"+tc);

			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}


	}

}
