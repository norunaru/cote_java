package mAlgo;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 무향 그래프
 
 한 정점에서 시작된 정보를 연결된 모든 정점에 전파
 사람 수 N
 사람은 1번부터 차례로 번호
 연결된 사람 쌍의 수 M
 (M줄)
 A B
 
 소문을 알게 되는 모든 사람들의 수? (true 개수 -1)
 
 
 
 큐를 사용해 bfs
 큐에 넣을 때 이전에 처리한 정점인지 확인하고, 처리했었다면 패스
 
 */
public class mAlgo1_대전_6반_노우영 {
	static int N,M;
	static Queue<Integer> queue = new ArrayDeque<>();
	static int[][] arr;
	static boolean[] know;
	static int result=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		know= new boolean[N];
		
		
		M = Integer.parseInt(br.readLine());
		
		//인접행렬 생성
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from,to;
			from = Integer.parseInt(st.nextToken())-1; //인덱스로 쓰기 위해 -1
			to = Integer.parseInt(st.nextToken())-1;
			
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		//1번 사람(0인덱스)부터 시작
		queue.offer(0);
		know[0] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
//			System.out.println(cur);
			
			for(int i=0; i<N; i++) {
				if(arr[cur][i]==1 && know[i]==false) { //이미 알고있는 사람은 큐에 넣을 필요 없음
					know[i] = true;
					queue.offer(i);
				}
			}
		}
	
		for(int i=0; i<N; i++) {
			if(know[i]==true)result++;
		}
		
		System.out.println(result-1); //나 자신은 빼야됨
		
		
	}
	
}
