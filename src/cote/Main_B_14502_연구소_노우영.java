package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
바이러스 유출
N*M
빈칸0, 벽1, 바이러스2
상하좌우 유출
새로 벽 3개 세우기 가능
벽 없으면 모든 빈칸으로 번짐
----------------------------------------------
로직 : 
2차원배열 조합, (N*M)C3
3개 고르는데 1,2있으면 그곳에는 벽 설치 불가능하므로 그 경우는 패스
조합으로 나온 위치에 벽 설치하고 인덱스 하나씩 바꿔가면서 2(바이러스)찾고 dfs해서 연결된 곳 바이러스 퍼지게 설정
해당 조합의 결과로 0 개수 카운트, 현재 저장된 결과값보다 크면 대체
----------------------------------------------
메모리 15844kb
시간 272ms
 */
public class Main_B_14502_연구소_노우영 {
	static int N,M;
	static int[][] arr;
	static int[][] copyArr;
	static int[][] picked = new int[3][2]; //3개 뽑은 좌표 저장, 각 행에 y,x좌표가 쌍으로 3개 들어있음
	static int result =0;

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		copyArr = new int[N][M]; //각 조합마다 다르게 사용해야되는데 원본 건들면 안되므로 복사본 사용
		//지도만들기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
			}
		}

		comb(0,0);
		System.out.println(result);

	}//main



	private static void comb(int cnt, int start) {
		if(cnt == 3) {

			//조합 만들었는지 확인 출력
			//			for(int i=0; i<3; i++) {
			//				System.out.println(Arrays.toString(picked[i]));
			//			}
			//			System.out.println();


			//picked = [[y1,x],[y2,x2],[y3,x3]]으로 좌표값들이 저장되어있음
			int y1,y2,y3,x1,x2,x3;
			y1=picked[0][0];
			y2=picked[1][0];
			y3=picked[2][0];
			x1=picked[0][1];
			x2=picked[1][1];
			x3=picked[2][1];


			//선택한 조합의 공간이 셋 다 0일때만 실행 - 벽이 있는곳이나 바이러스 있는 곳에는 벽 설치 불가 -> 해당 조합은 생략
			if(arr[y1][x1]==0 && arr[y2][x2]==0 && arr[y3][x3]==0) {
				//원본 건들면 안되니까 복사본으로 검사
				//복사본 생성
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						copyArr[i][j] = arr[i][j];
					}
				}
				//저장했던 인덱스들 이용하여 벽세우기
				copyArr[y1][x1] = 1;
				copyArr[y2][x2] = 1;
				copyArr[y3][x3] = 1;

				//dfs
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {

						if(copyArr[i][j] == 2) {
							dfs(i,j);
						}
					}
				}

				int temp=0; //0개수 저장할 변수

				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(copyArr[i][j] == 0) {
							temp++;
						}
					}
				}

				if(temp>result) {
					result = temp;
//					for(int i=0; i<3; i++) {
//						System.out.println(Arrays.toString(picked[i]));
//					}
//					for(int i=0; i<N; i++) {
//						System.out.println(Arrays.toString(copyArr[i]));
//					}
//					System.out.println();
				}
			}
			return;
		}//조합 완성 블록(cnt==3)

		//2차원배열 조합
		for(int i=start; i<N*M; i++) {
			int r = i/M;
			int c = i%M;

			//y,x좌표를 picked에 저장
			picked[cnt][0] = r;
			picked[cnt][1] = c;

			comb(cnt+1, i+1);
		}
	}//comb

	private static void dfs(int y, int x) {
		copyArr[y][x] = 2;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny>=0 && ny<N && nx>=0 && nx<M && copyArr[ny][nx]==0) { //범위 내, 빈칸이면 바이러스 번질 수 있음
				dfs(ny,nx);
			}
		}

	}



}