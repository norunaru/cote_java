package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class test {
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static List<Integer> list = new ArrayList<Integer>();
	static Stack<Integer> stk = new Stack<Integer>();
	
	static int N,R;
	static int[] result;
	static int[] numbers;
	static boolean[] isUsed;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		result = new int[R];
		isUsed = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
//		perm(0);
		comb(0,0);
		/*
		 5 3
		 1 2 3 4 5
		 */
	}
	
	static void perm(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isUsed[i]==false) {
				isUsed[i] = true;
				result[cnt] = numbers[i];
				perm(cnt+1);
				isUsed[i] = false;
			}
		}
	}
	
	static void comb(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[cnt] = numbers[i];
			comb(cnt+1, i+1);
		}
	}

}
