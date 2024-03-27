package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 현재 무게에 대해
 max(현재 무게에 저장된 최대가치, 현재무게-물건무게에 저장된 가치 + 현재물건가치)

 물건 N개 -> 무게W, 가치V
 가방 최대무게 K
 가치 최댓값?
 
 51428kb 148ms
 */
public class Main_B_12865_평범한배낭_노우영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N,K;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //물건 개수
		K = Integer.parseInt(st.nextToken()); //가방 무게 한도

		int[][] dp = new int[N+1][K+1];
		int[] weights = new int[N+1];
		int[] values = new int[N+1];

		//물건무게, 가치 저장
		for(int i=1; i<N+1; i++) {
			int W,V;
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			weights[i] = W;
			values[i] = V;
		}

		for(int i=1; i<N+1; i++) { //물건 인덱스
			int curW = weights[i];
			int curV = values[i];
			
			//물건인덱스 0 = 1번물건
			//각 무게에 대해 처리 1~K kg, 0kg은 다 0으로 놔두기
			for(int w=1; w<K+1; w++) {
				if(w>=curW) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-curW]+curV); //현재 처리하는 무게에서 저장된 값, 현재무게-물건무게에 저장된값+물건가치 중 큰 값 선택
				}else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		
		System.out.println(dp[N][K]);

		
		
		
	}
}
