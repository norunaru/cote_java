package cote;
/*
 배열의 값은 행의 합 중 최소값
 회전 연산(y,x,s) 좌상단이 y-s,x-s   우하단이 y+s,c+s
 
 5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1

메모리 : 18748kb
시간 : 248ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_17406_배열돌리기4_노우영 {
	static int N,M,K;
	static int[][] arr;
	static int y,x,s;
	static int flag;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	static boolean[] isSelected;
	static int[] Y,X,S;
	static StringBuilder sb = new StringBuilder();
	static int[] permResult;
	static int result=Integer.MAX_VALUE; //정답 변수
	static int[][] copyArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		K = Integer.parseInt(st.nextToken()); //회전
		
		permResult = new int[K];
		
		arr = new int[N][M];
		copyArr = new int[N][M];
		isSelected = new boolean[K];
		Y = new int[K];
		X = new int[K];
		S = new int[K];
		
		
		
		//배열만들기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//회전연산 정보
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken()) -1; //인덱스 0부터 사용하므로 -1처리
			x = Integer.parseInt(st.nextToken()) -1;
			s = Integer.parseInt(st.nextToken());
			
			//0~K-1인덱스 사용
			//입력받는 y,x,s를 각각 배열에 저장하고, 인덱스로 순열을 만들어서 순열에 따라 결과 연산
			Y[i] = y;
			X[i] = x;
			S[i] = s;
//			spin(y-s,x-s);
			
		}
//		System.out.println(Arrays.toString(Y));
//		System.out.println(Arrays.toString(X));
//		System.out.println(Arrays.toString(S));
		perm(0);
		
		//원본
//		for(int d=0; d<N; d++) {
//			System.out.println(Arrays.toString(arr[d]));
//		}
		
		System.out.println(result);
	}//main
	 private static void perm(int cnt) {
	        if(cnt == K) {
	        	//원본 복사 
	        	for(int i=0; i<N; i++) {
	    			for(int j=0; j<M; j++) {
	    				copyArr[i][j] =  arr[i][j];
	    			}
	    		}
	        	//복사본으로 순열 결과에 따라 돌리기
	        	for(int i=0; i<K; i++) {
//	        		System.out.println(Y[permResult[i]]-S[permResult[i]]);
//	        		System.out.println(X[permResult[i]]-S[permResult[i]]);
	        		spin(Y[permResult[i]]-S[permResult[i]],X[permResult[i]]-S[permResult[i]],S[permResult[i]]);

//	        		for(int d=0; d<N; d++) {
//		    			System.out.println(Arrays.toString(copyArr[d]));
//		    		}
//		        	System.out.println();
	        	}
	        	
	        	//돌린 결과 
//	        	for(int d=0; d<N; d++) {
//	    			System.out.println(Arrays.toString(copyArr[d]));
//	    		}
//	        	System.out.println();
	        	
	        	
	        	//돌린거로 행의 합 가장 작은거 찾기
	        	for(int i=0; i<N; i++) {
	        		int tempSum=0;
	        		for(int j=0; j<M; j++) {
	        			tempSum+=copyArr[i][j];
	        		}
//	        		System.out.println(tempSum);
	        		if(tempSum<result) result = tempSum;
	        	}
	            return;
	        }

	        for(int i = 0; i < K; i++) {
	            if(isSelected[i]) continue;
	            permResult[cnt] = i;
	            isSelected[i] = true;
	            perm(cnt + 1);
	            isSelected[i] = false;
	        }
	    }
	
	private static void spin(int startY, int startX, int s) { //startY = y-s  startX = x-s
		//s==회전해야할 껍질 개수
		int spinCnt = s;
		int curY = startY;//이번 회전에서 사용할 좌표
		int curX = startX;
		
		//=======================================================================
		for(int i=0; i<spinCnt; i++) {
			int temp = copyArr[curY][curX]; //이후에 지워질 값 저장
			
			for(int dir=0; dir<4; dir++) { //4방향으로 회전
				for(int j=0; j<s*2; j++) {//s번 이동
					copyArr[curY][curX] = copyArr[curY+dy[flag]][curX+dx[flag]];
					curY = curY+dy[flag];
					curX = curX+dx[flag];
				}
				flag++;
				flag=flag%4;
			}
			
			copyArr[curY][curX+1] = temp; //아까 저장했던 값 넣기
			curY+=1;
			curX+=1;
			s--;
		}//=======================================================================
	}
}