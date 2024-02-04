package baekjoon;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class Solution_1225_암호생성기_노우영 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc=1; tc<T+1; tc++) { //tc
			Queue<Integer> q = new ArrayDeque<Integer>();
			int temp;
			
			int a = s.nextInt();
			
			for(int i=0; i<8; i++) {
				temp = s.nextInt();
				q.offer(temp);
			}
			int cnt = 1;
						
			while(true) {
				temp = q.poll(); //맨 앞 빼고
				temp -= cnt; //줄이고
				
				
				if(temp <= 0) {
					temp = 0;
					q.offer(temp);
					break;
				}
				q.offer(temp);
				cnt += 1;
				if(cnt % 5 == 1) cnt = 1;	
			}
			
			System.out.print("#"+tc+" ");
			while(!q.isEmpty()) {
				
//			for(int i=0; i<8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
			
		}
		
		
		
	}

}
