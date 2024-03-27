package mAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 업무는 주어진 순서대로 진행
 새로운 업무 받으면 새거 바로 시작
 
 새 업무 끝나면 이전 업무 이어서 한다 -> 원래 있던거 -> 스택
 N
 */

public class mAlgo2_대전_6반_노우영 {
	static Stack<Node> stk = new Stack<>();
	static int totalScore = 0;
	static int N,A,T;
	
	static Node top;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if(num==1) {
				A = Integer.parseInt(st.nextToken()); //업무의 점수
				T = Integer.parseInt(st.nextToken()); //해결에 걸리는 시간
				stk.add(new Node(A,T));
//				stk.peek().timeLeft--;
//				if(stk.peek().timeLeft==0) {
//					totalScore += stk.peek().score;
//					stk.pop();
//				}
				
			}
			//공통실행부
			//가장 최근에 받은 업무의 시간 -1, 0되면 팝, 점수 추가
			stk.peek().timeLeft--;
			if(stk.peek().timeLeft==0) {
				totalScore += stk.peek().score;
				stk.pop();
			}
			
		}
		System.out.println(totalScore);
	}

	
	static class Node{
		int timeLeft;
		int score;
		
		Node(int score, int timeLeft){
			this.score = score;
			this.timeLeft = timeLeft;
		}
	}
	
	
	
}
