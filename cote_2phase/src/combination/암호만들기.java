package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 암호는 L개 알파벳 소문자로 구성 
 최소 한 개의 모음 + 최소 두 개의 자음
 알파벳 증가하는 순서 -> bac(x)
 암호로 사용한 문자 종류 C개
 C개 문자가 주어졌을 때 가능성 있는 암호 개수

 입력
 첫째 줄에 L,C (3<=L<=C<=15)
 다음 줄에 c개의 문자들이 공백으로 구분되어 주어짐
 주어진 문자 중 중복 없음
 
 프로세스
 1. 주어진 문자들 정수형으로 배열에 저장
 2. 배열 정렬
 3. 조합
 4. 완성시 모음 1개, 자음 2개 있으면 출력, 없으면 리턴
 */

public class 암호만들기 {
	static int N,R;
	static char[] arr;
	static char[] result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new char[N];
		result = new char[R];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
//		System.out.println(arr);
		
		
		comb(0,0);
		
	}//main
	
	static void comb(int cnt, int start) {
		//기저조건 - R개 고르고 모음 1개 이상, 자음 2개 이상이면 출력
		if(cnt==R) {
			int mom = 0;
			int son = 0;
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<R; i++) {
				sb.append(result[i]);
				if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i]=='o' || result[i]=='u') mom++;
				else son++;
			}
			if(mom>=1 && son>=2) 
				System.out.println(sb);
			return;
		}
		
		
		for(int i=start; i<N; i++) {
			result[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
		
		
		
	}//comb
}


































