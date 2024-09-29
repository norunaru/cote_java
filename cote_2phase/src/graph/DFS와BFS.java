package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 그래프를 DFS, BFS로 탐색한 결과를 출력
 방문 정점이 여러 개면 정점 번호가 작은것 먼저 방문
 방문할 수 있는 점이 없으면 종료
 
 정점 N(1<=N<=1000), 간선 M(1<=M<=10000), 탐색 시작 정점 번호 V
 다음 M개줄 -> 간선이 연결하는 두 정점의 번호 (두 정점 사이에 여러 개의 간선 존재 가능, 입력으로 주어지는 간선은 양방향
 
 
 */
public class DFS와BFS {
	static int N,M,V; //정점, 간선, 시작 정점
	static boolean[] isVisited1, isVisited2;
	
	
	static List<Integer>[] adjList;
	static Queue<Integer> queue = new ArrayDeque<>();
	
	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		isVisited1 = new boolean[N+1];
		isVisited2 = new boolean[N+1];
		
		adjList = new List[N+1];
		
		for(int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		for(int i=0; i<N+1; i++) {
			adjList[i].sort(null);
		}
		
		dfs(V);
		System.out.println(sb1);
		
		bfs(V);
		System.out.println(sb2);
		
		
	}//main
	
	static void dfs(int start) {
		isVisited1[start] = true;
		sb1.append(start).append(" ");
		
		for(int temp : adjList[start]) {
			if(isVisited1[temp]==false) dfs(temp);
		}
		
	}//dfs
	
	static void bfs(int start) {
		isVisited2[start] = true;
		sb2.append(start).append(" ");
		
		queue.offer(start);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int temp : adjList[current]) {
				if(isVisited2[temp]==false) {
					isVisited2[temp] = true;
					queue.offer(temp);
					sb2.append(temp).append(" ");
				}
				
			}
		}
		
	}//bfs

}
































