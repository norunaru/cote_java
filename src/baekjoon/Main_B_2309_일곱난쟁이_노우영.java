package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B_2309_일곱난쟁이_노우영 {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);

	        int[] height = new int[9];

	        for (int i = 0; i < 9; i++) {
	            height[i] = s.nextInt();
	        }

	        int sum9 = 0;
	        
	        for(int i=0; i<9; i++) sum9 += height[i];
	        	
	        
	        
	        int target = sum9 - 100;

	        int a = 0, b = 0;

	        // 빌런 찾기
	        for (int i = 1; i < 9; i++) {
	            for (int j = 0; j < i; j++) {
	                if (height[i] + height[j] == target) {
	                    a = i;
	                    b = j;
	                    break;
	                }
	            }
	        }

	        // 빌런 삭제
	        int[] result = new int[7];
	        int idx = 0;
	        for (int i = 0; i < 9; i++) {
	            if (i != a && i != b) {
	                result[idx++] = height[i];
	            }
	        }

	        Arrays.sort(result);

	        for (int i = 0; i < 7; i++) {
	            System.out.println(result[i]);
	        }
	    }
	}