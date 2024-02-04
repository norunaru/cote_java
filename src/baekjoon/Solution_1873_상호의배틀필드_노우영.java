package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//오답
//채점용 input 파일로 채점한 결과 fail 입니다.
//(오답 : 98개의 테스트케이스 중 90개가 맞았습니다.)



public class Solution_1873_상호의배틀필드_노우영 {
	static int Y,X;
	static int y,x;
	static int dir; //0상 1하 2좌 3우
	static int Y2,X2;
	static int ny,nx;

	static int[][] delta = {{-1,0}, {1,0} ,{0,-1},{0,1}};
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		
		for(int tc=1; tc<T+1; tc++) {
			 y = s.nextInt();
			 x = s.nextInt();
			s.nextLine();
			char[][] map = new char[y][];
			//맵 채우기
			for(int i=0; i<y; i++) {
				String str = s.nextLine();
				map[i] = str.toCharArray();
			}

//			for(int i=0; i<y; i++) {
//				for(int j=0; j<x; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}

			A:for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(map[i][j] == '^') {
						dir = 0;
						Y = i;
						X = j;
						break A;
					}
					else if(map[i][j] == 'v') {
						dir = 1;
						Y = i;
						X = j;
						break A;
					}
					else if(map[i][j] == '<') {
						dir = 2;
						Y = i;
						X = j;
						break A;
					}
					else if(map[i][j] == '>') {
						dir = 3;
						Y = i;
						X = j;
						break A;
					}
				}
			}
//			System.out.println("시작 위치 : " +Y + " " + X);
			int userInput = s.nextInt();
			s.nextLine();
			String str2 = s.nextLine();
			char[] command = str2.toCharArray();
			
//			System.out.println(Arrays.toString(command));

			//위치 Y,X
			//0상 1하 2좌 3우
			for(char c : command) {
//				System.out.println("current command : "+c);
				if(c == 'U') {
					dir = 0;
					if((Y-1)>= 0 && map[Y-1][X] == '.') {
						map[Y][X] = '.';
						Y = Y -1;
						map[Y][X] = '^';
					}else {
						map[Y][X] = '^';
					}
				}else if((Y+1)<=y-1 && c == 'D') {
					dir = 1;
					if(map[Y+1][X] == '.') {
						map[Y][X] = '.';
						Y = Y + 1;
						map[Y][X] = 'v';
					}else {
						map[Y][X] = 'v';
					}

				}else if((X-1)>=0 &&c == 'L') {
					dir = 2;
					if(map[Y][X-1] == '.') {
						map[Y][X] = '.';
						X = X-1;
						map[Y][X] = '<';
					}else {
						map[Y][X] = '<';
					}

				}else if((X+1)<=x-1 &&c == 'R') {
					dir = 3;
					if(map[Y][X+1] == '.') {
						map[Y][X] = '.';
						X = X+1;
						map[Y][X] = '>';
					}else {
						map[Y][X] = '>';
					}

				}else if(c == 'S') {
					Y2 = Y; //대포알 위치
					X2 = X;
				
					ny = Y2 + delta[dir][0];
					nx = X2 + delta[dir][1];
					
					while(ny>=0 && ny<=y-1 && nx>=0 && nx<=x-1) {
						
						
						if(map[ny][nx]=='*') {
							map[ny][nx] = '.';
							break;
						}else if(map[ny][nx]=='#') {
							break;
						}
						
						ny += delta[dir][0];
						nx += delta[dir][1];
					}
					
				}
				
//				for(int i=0; i<y; i++) {
//					for(int j=0; j<x;j++) {
//						System.out.print(map[i][j] + " ");
//					}
//					System.out.println();
//				}
			}//command
			
//			for(int i=0; i<y; i++) {
//				for(int j=0; j<x;j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<y; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<x;j++) {
					sb.append(map[i][j]);
				}
				System.out.println(sb);
			}
			
			
			
		}//tc

	}//main

}

