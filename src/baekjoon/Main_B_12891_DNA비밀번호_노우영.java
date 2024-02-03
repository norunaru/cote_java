package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B_12891_DNA비밀번호_노우영 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int DNA_len = s.nextInt();
		int part_len = s.nextInt();
		
		
		s.nextLine();
		String input = s.nextLine();
		
		char[] DNA = new char[DNA_len];
		
		for(int i=0; i< DNA_len; i++) {
			DNA[i] = input.charAt(i);
		}
		int min_A, min_C, min_G, min_T;
		min_A = s.nextInt();
		min_C = s.nextInt();
		min_G = s.nextInt();
		min_T = s.nextInt();
		
		int cnt = 0;
//		int[] min = new int[4];
////		System.out.println(Arrays.toString(DNA));
//		
//		
//		
//		for(int start=0; start<DNA_len - part_len+1; start++) {
//			for(int end=start; end<start + part_len; end++) {
////				System.out.println("start:"+start +" "+ "end :" + end);
//				if(DNA[end] == 'A') min[0]++;
//				else if(DNA[end] == 'C') min[1]++;
//				else if(DNA[end] == 'G') min[2]++;
//				else if(DNA[end] == 'T') min[3]++;
//			}
//			if(min[0]>=min_A && min[1]>=min_C && min[2]>=min_G && min[3]>=min_T) cnt++;
//			min[0] = 0;
//			min[1] = 0;
//			min[2] = 0;
//			min[3] = 0;
//		}
		
		int[] temp_cnt = new int[4];
		
		//초기 부분문자열에 대해 개수 설정
		for(int i=0; i<part_len; i++) {
			if(DNA[i] == 'A') temp_cnt[0]++;
			else if(DNA[i] == 'C') temp_cnt[1]++;
			else if(DNA[i] == 'G') temp_cnt[2]++;
			else if(DNA[i] == 'T') temp_cnt[3]++;
		}
		//맨 앞글자는 제거, 뒤 글자는 추가
		for(int current=part_len; current<DNA_len; current++) {
			int front=current-part_len;
			//맨 앞은 빼주고
			if(DNA[front] == 'A') temp_cnt[0]--;
			else if(DNA[front] == 'C') temp_cnt[1]--;
			else if(DNA[front] == 'G') temp_cnt[2]--;
			else if(DNA[front] == 'T') temp_cnt[3]--;
			//현재 위치는 더해준다
			if(DNA[current] == 'A') temp_cnt[0]++;
			else if(DNA[current] == 'C') temp_cnt[1]++;
			else if(DNA[current] == 'G') temp_cnt[2]++;
			else if(DNA[current] == 'T') temp_cnt[3]++;
			//각 문자 개수에 대해 확인하고 조건에 맞으면 cnt 증가
			if(temp_cnt[0]>=min_A && temp_cnt[1]>=min_C && temp_cnt[2]>=min_G && temp_cnt[3]>=min_T) cnt++;
		}
		
		System.out.println(cnt);
	
		
	}

}