package baekjoon;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
public class Main_B_2164_카드2_노우영 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Queue<Integer> q = new ArrayDeque<Integer>();
		int temp;
		int N = s.nextInt();
		int result;
		
		for(int i=0; i<N; i++) {
			q.offer(i+1);
		}
		
//		System.out.println(q.peek());
		
		
		while(true) {
			q.poll();
			temp = q.poll();
			q.offer(temp);
			if(q.size() == 1) {
				result = q.peek();
				break;
			}
		}
		System.out.println(result);
		
		
	}

}
