package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class asdf {
	static int N;
	static char[] arr; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		System.out.println(input);
		N = input.length();
		arr = input.toCharArray();
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<N; i++) {
			int sum = 0;
			if(arr[i]=='A') {
				arr[i] = (sum); //char로 변경해서 해서 넣기
			}else if(arr[i] == 'B') {
				arr[i] = 
			}
		}
	}

}
