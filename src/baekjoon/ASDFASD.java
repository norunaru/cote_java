package baekjoon;
import java.util.Arrays;

public class ASDFASD {
	public static void main(String[] args ) {
		String a = "123456789";
		char[] c = new char[a.length()];
		c = a.toCharArray();
		int sum = 0;
		
		for(int i =0; i<c.length;i++) {
			sum += c[i] - '0';
		}
		
		System.out.printf("%d",sum);
		
	}
}
