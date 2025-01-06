package string;
/*
 숫자 0~9, +, -로 식을 만들고 괄호를 모두 지움
 괄호를 적절히 쳐서 식의 값을 최소로 만들기
 
 처음, 마지막 문자는 숫자
 연속으로 두 개 이상의 연산자 불가, 5자리 이상 숫자 x
 수는 0으로 시작 가능
 
 프로세스 : 
 문자열 입력
 -가 나오면 (, 다음 -나오면 -앞에서 )
 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		
		int result = 0;
		//?+?+?-(?+?+?)-?
		
		// ??+??, ??+??+??, ... 
		while(sub.hasMoreTokens()) {
			int temp = 0;
			
			//??+??+??
			StringTokenizer add = new StringTokenizer(br.readLine(), "+");
			
			while(add.hasMoreTokens()) {
				temp += Integer.parseInt(add.nextToken());
			}
			
			if(result == 0) {
				result = temp;
			}else result -= temp;
			
			System.out.println(result);
		}
		
		

		
		
		
		
		
		
		
	}

}
