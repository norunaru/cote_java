package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 1~49중 6개 선정
 49개 숫자중 k개 골라 집합을 만들고 그 수만 가지고 번호 선택, k>6
 
 집합 S와 k가 주어졌을 떄 수를 고르는 모든 방법
 
 입력:
 여러 테케로 구성
 첫 번쨰 수는 k(6<k<13), 다음 k개 숫자는 S에 포함되는 수, 오름차순
 입력 마지막줄에는 0주어짐
 
 프로세스:
 while로 반복
 0이면 종료
 첫 숫자는 k로 설정, 나머지 숫자들은 배열에 저장
 kC6 수행, stringbuilder
 */
public class 로또 {
	static int k;
	static int[] numbers;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) {
				break;
			}
			
			numbers = new int[k];
			ans = new int[6];
			for(int i=0; i<k; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			System.out.println();
		}
		
	}//main
	static void comb(int cnt, int start) {
		if(cnt==6) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<6; i++) {
				sb.append(ans[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i=start; i<k; i++) {
			ans[cnt] = numbers[i];
			comb(cnt+1, i+1);
		}
		
	}

}











