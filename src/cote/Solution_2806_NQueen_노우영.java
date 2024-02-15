package cote;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
 랜선 N개 만들어야됨
 현재 K개 갖고있는데 길이가 다 다름
 모두 같은 길이 N개로 만들기 위해 K개 랜선을 잘라야됨
 300 -> 140*2 + 20
 N개 이상 만들어도됨
 
 1 <= K <= 10000
 1 <= N <= 1000000
 K<=N
 만들 수 있는 랜선의 최대길이?
 
 메모리 27508 시간 344
 */
public class Main_B_1654_랜선자르기_노우영 {
	static int K,N;
	static long[] cable;
	static long mid;
	static long cableCnt;
	static long longest=0;
	
	static long result;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		K = s.nextInt();
		N = s.nextInt();
		cable = new long[K];
		
		for(int i=0; i<K; i++) {
			cable[i] = s.nextInt();
		}
		
		//정렬
		Arrays.sort(cable);
		
		long from = 1;
		long to = cable[K-1];
		
		binary(from, to, cable);
		
		System.out.println(result);

	}
	static void binary(long start, long end, long[] cable) {
		if(start>end) return;
		
		cableCnt=0;
		mid = (start+end)/2;
		
		for(int i=0; i<K; i++) {
			cableCnt += cable[i] / mid;
		}
		
		if(cableCnt>=N) { //원하는 개수와 같거나 더 많이 나왔을 경우 -> 최장길이 구해야됨 -> 구한 mid를 start로 활용해 재귀
			result = mid;//일단 현재값 결과에 저장
			binary(mid+1,end, cable);
			
		} else { //목표하던 개수보다 적게 나왔으면 (더 짧게 잘라 개수를 늘려야되면)
			binary(start,mid-1,cable);
		} 
			
		
	}
	
}
