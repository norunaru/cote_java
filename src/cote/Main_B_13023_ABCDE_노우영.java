package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
N명 0~N-1

A-B 
B-C 
C-D 
D-E

사람수 N (5~2000)
친구관계수 M(1~2000)

M줄 a,b = a,b는 친구

(from,to)가 1이면 visited true로 설정하고
to 행에 대해 쭉 검사 visited == false이고, 1이면 다시 그 다음 행에 대해 검사 

 */
public class Main_B_13023_ABCDE_노우영 {
	static int N,M;
	static int[][] arr;
	static List<Integer>[] listArr;
	static int result = 0;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //사람 수
		M = Integer.parseInt(st.nextToken()); //친구 관계의 수

		isVisited = new boolean[N];
		arr = new int[N][N];

		listArr = new List[N];
		for (int i = 0; i < N; i++) {
			listArr[i] = new ArrayList<>(); // 인접 리스트 초기화
		}

		//인접행렬만들기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			//			arr[a][b] = 1; //a가 b를 안다고 표시
			//			arr[b][a] = 1;
			listArr[a].add(b);
			listArr[b].add(a);
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<listArr[i].size(); j++) {
				//매 시작 인덱스마다 새로운 테케 -> isVisited 초기화
				for(int k=0; k<N;k++) {
					isVisited[k] = false;
				}
				int friend = listArr[i].get(j);
				isVisited[i] = true;
				isVisited[friend] = true;
				dfs(friend,2,isVisited);

			}
		}

		System.out.println(result);

	}//main
	private static void dfs(int j, int cnt, boolean[] isVisited) {
		if(cnt==5) {
			result = 1;
			return;
		}

		for(int x=0; x<listArr[j].size(); x++) {
			int friend = listArr[j].get(x);
			if(isVisited[friend]==false) {
				isVisited[friend] = true;
				dfs(friend,cnt+1,isVisited);
				isVisited[friend] = false;
			}
		}

	}//dfs
}

