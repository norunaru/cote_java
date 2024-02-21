package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_노우영 {
	static int T;
	static int n, m;
	static int first, second;
	static int command;
	static int temp;
	static int[] parent;



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		T = Integer.parseInt(br.readLine());

		for(int i=1; i<T+1; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(i+" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //숫자 개수, 1~n
			m = Integer.parseInt(st.nextToken()); //주어지는 연산 개수

			parent = new int[n+1];
			for(int k=1; k<n+1; k++) {
				parent[k] = k;
			}
			//m개 줄에 각각의 연산
			for(int a=0; a<m; a++) {
				st = new StringTokenizer(br.readLine());
				command = Integer.parseInt(st.nextToken());
				first = Integer.parseInt(st.nextToken());
				second = Integer.parseInt(st.nextToken());

				if(command == 0) union(first,second);
				else if(command==1) {
					temp = find(first,second);
					sb.append(temp);
				}
			}
			
			System.out.println(sb);
		}//tc

	}//main

	private static void union(int first, int second) {
		if(find(first,second)==1) return;
		else parent[find2(second)] = find1(first); //second 부모를 first로 설정
	}

	private static int find(int first, int second) {
		int root1 = find1(first);
		int root2 = find2(second);
		
		if(root1 == root2) return 1;
		else return 0;
	}

	private static int find1(int first) {
		if(parent[first] == first) return first;
		else return parent[first] = find1(parent[parent[first]]);
	}
	
	private static int find2(int second) {
		if(parent[second] == second) return second;
		else return parent[second] = find2(parent[parent[second]]);
	}










}
