package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1_노우영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<String> code = new ArrayList<>();
		for(int tc=1; tc<=10; tc++) {
			code.clear();
			
			int N = Integer.parseInt(b.readLine()); //원본 암호문 길이 (0~999999 사이 숫자 N개)
			
			
			StringTokenizer st = new StringTokenizer(b.readLine());
			
			while(st.hasMoreTokens()) {
				code.add(st.nextToken());
			}

			int commands = Integer.parseInt(b.readLine()); //명령어 개수
			StringTokenizer st2 = new StringTokenizer(b.readLine()); //명령어
			for(int command=0; command<commands; command++ ) { //7번반복
				st2.nextToken();
				int idx = Integer.parseInt(st2.nextToken());
				int num = Integer.parseInt(st2.nextToken()); //넣을 숫자 개수
				
				for(int n=0; n<num; n++) {
					code.add(idx,st2.nextToken());
					idx++;
				}
			}
			System.out.print("#"+tc+" ");
			for (String value : code.subList(0, Math.min(10, code.size()))) {
			    System.out.print(value + " ");
			}
			System.out.println();
			
			
//			sb.append('#').append(tc).append(' ');
//            for(int i=0;i<10;i++) {
//                sb.append(code.get(i)).append(' ');
//            }
//            sb.append('\n');

		}//tc
		
		
	}

}
