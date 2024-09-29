package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 조건:
 주사위 1~6
 10*10 보드판, 1~100까지 수
 주사위 굴린 만큼 이동
 i번칸, 주사위 4 -> i+4번 칸으로 이동
 100넘어가면 이동 불가
 도착 칸이 사다리면 사다리 타고 위로 이동
 뱀 칸 도착시 내려감
 한 칸에 뱀과 사다리 둘다 가질 수는 없음
 
 입력: 
 사다리 수 N(1<=N<=15), 뱀의 수 M(1<=M<=15)
 N개 줄에 사다리 정보 x,y (x칸 도착시 y로 이동)
 M개 줄에 뱀 정보 u,v (u칸 도착시 v로 이동)
 
 
 */
public class 뱀과사다리게임 {
	static int N,M,U,V;
	static int[] board = new int[101];
	static int[] cnt = new int[101];
	
	static Queue<Node> queue = new ArrayDeque<Node>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<101; i++) {
			board[i] = i;
		}
		
		//사다리
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			board[from] = to;
		}
		
		//뱀
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			board[from] = to;
		}
		
		queue.offer(new Node(1,0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int curVal = cur.val;
			int curCnt = cur.cnt;
			
			int nVal;
			
			for(int i=1; i<=6; i++) {
				nVal = curVal + i;
				
				nVal = board[nVal];
				
				if(nVal >= 100) {
					System.out.println(curCnt+1);
					return;
				}
				else if(cnt[nVal]==0) {
					queue.offer(new Node(nVal, curCnt+1));
					cnt[nVal] = curCnt+1;
				}
			}
		}
		
		System.out.println(cnt[100]);
	

	}// main
	
	static class Node{
		int val;
		int cnt;
		Node(int val, int cnt){
			this.val = val;
			this.cnt = cnt;
		}
		
	}

}




























