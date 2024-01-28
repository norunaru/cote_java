package baekjoon;
//1629
import java.util.Scanner;


//자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
public class Power_mod {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		long A = s.nextInt();
		long B = s.nextInt();
		long C = s.nextInt();
		
		long result = powMod(A,B,C);
		System.out.println(result);
			
	}
	public static long powMod(long A, long B, long C) {
		if(B == 1) return A % C; //base condition, B==0으로 해도 상관없다
		
		long val = powMod(A, B/2, C); // 1/2승의 나머지값을 구한것을 val에 대입
		val = val * val % C; 
		
		if(B%2 == 0) return val;
		else return val * A % C;
	}
}
