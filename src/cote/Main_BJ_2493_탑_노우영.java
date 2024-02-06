package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;



//5
//6 9 5 7 4

/*
 * 1. 스택이 비어있다면 0을 sb에 더하고, 현재 탑을 스택에 push
 * 2. 비어있지 않다면  
 * 2-1. 스택에 peek한 탑의 높이가 현재 탑의 높이보다 높다면, peek한 탑의 번호를 출력하고, 현재 탑을 스택에 push한다.
 * 2-2. 스택에 peek한 탑의 높이가 현재 탑의 높이보다 낮다면, peek한 탑을 pop하고 2번으로 다시 돌아간다.
 */
public class Main_BJ_2493_탑_노우영 {
	static class Tower {
		int idx, height;
		Tower(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(b.readLine());
		int[] result = new int[N];
		
		Stack<Tower> stk = new Stack<Tower>();
		
		StringTokenizer st = new StringTokenizer(b.readLine());
//		System.out.println(st);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			Tower current = new Tower(i, Integer.parseInt(st.nextToken()));
//			System.out.println(current.height + " " + current.idx);
			
			if(stk.isEmpty()) {
				sb.append(0).append(" ");
				stk.push(current);
			} else {
				while(true) {
					if(stk.isEmpty()) {
						sb.append(0 + " ");
						stk.push(current);
						break;
					}
					if(stk.peek().height >= current.height) {
						sb.append(stk.peek().idx).append(" ");
						stk.push(current);
						break;
					} else {
						stk.pop();
					}
				}
			}
		}
		System.out.println(sb);
	}
	
}













// 메모리 초과 코드
//
//public class Main_BJ_2493_탑_노우영 {
//
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int N = s.nextInt();
//		int[] heights = new int[N];
//		
//		for(int i=0; i<N; i++) {
//			heights[i] = s.nextInt();
//		}
////		System.out.println(Arrays.toString(heights));
//		
//		
//		int[] result = new int[N]; //결과(인덱스)를 저장할 배열
//		
//		Stack<Integer> stk = new Stack<>();
//		for(int h : heights) { //스택에 높이 값들 넣기
//			stk.push(h);
//		}
////		System.out.println(stack);
//		
//		Stack<Integer> stk2 = new Stack<>();
//		int cnt = N; //stk1에서 pop하는 인덱스
//		
//		while(stk.isEmpty() != true) {//스택이 비어있지 않으면 계속 pop
//			int temp = stk.pop();
//			cnt-=1;
//			if(stk2.isEmpty()) stk2.push(temp);
//			else { //스택2가 비어있지 않으면 스택2의 top과 비교, temp가 더 크면 stk2 pop
//				while(stk2.isEmpty()!=true && stk2.peek()<temp) {
//					int popped = stk2.pop();
//					for(int i=0;i<N;i++) {
//						if(heights[i]==popped) result[i] = cnt+1;
//					}		
//				}
//				stk2.push(temp);
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<N; i++) {
//			sb.append(result[i] + " ");
//		}
//		System.out.println(sb);
//		
//	}
//}

