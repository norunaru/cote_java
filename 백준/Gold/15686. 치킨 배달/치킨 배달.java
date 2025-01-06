import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 n*n 도시
 집과 가장 가까운 치킨집 사이 거리 -> |r1-r2| + |c1-c2|
 모든 치킨 거리의 합 = 도시의 치킨 거리
 집=1 치킨집=2
 M개 치킨집 빼고 다 폐업, 치킨 거리 최소 목적

 지도 만들면서 2나오면 배열에 저장
 집들도 배열에 저장
 */

public class Main {

	static int N,M;
	static int[][] map,chicken,home,temp;
	static int a=0,b=0;
	static int homeCnt=0, chickenCnt=0;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		temp = new int[M][];
		
		//지도 생성
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) homeCnt++;
				else if(map[i][j]==2) chickenCnt++;
			}
		}
		
		chicken = new int[chickenCnt][];
		home = new int[homeCnt][];
		
		//집이나 치킨집 위치를 배열에 저장
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					home[a] = new int[] {i,j}; //집 위치들을 가진 배열
					a++;
				} else if(map[i][j] == 2) {
					chicken[b] = new int[] {i,j}; //치킨집 위치들을 가진 배열
					b++;
				}
			}
		}
		
		comb(0,0);
		System.out.println(result);
		
	}//main
	private static void comb(int cnt, int start) {
		if(cnt==M) { //치킨집 M개 선택 완료
			int sum=0;
			//현재 집의 치킨거리 계산
			for(int i=0; i<homeCnt; i++) {
				int tempCnt = Integer.MAX_VALUE; //현재 집의 최소거리
				for(int j=0; j<M; j++) { //모든 치킨집과 비교
					if(tempCnt > Math.abs(home[i][0]-temp[j][0]) + Math.abs(home[i][1]-temp[j][1])) {
						tempCnt = Math.abs(home[i][0]-temp[j][0]) + Math.abs(home[i][1]-temp[j][1]);
					}
				}
				sum += tempCnt;
			}
//			System.out.println(sum);
			if(result>sum) result=sum;
			return;
		}
		
		
		for(int i=start; i<chickenCnt; i++) { //각 치킨집에 대해 
			temp[cnt] = chicken[i]; //현재 치킨집 저장
			comb(cnt+1, i+1);
		}
	}
	
	
}