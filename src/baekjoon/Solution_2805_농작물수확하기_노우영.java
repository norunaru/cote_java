package baekjoon;
import java.util.Scanner;

public class Solution_2805_농작물수확하기_노우영 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] farm;
        int T = s.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int size = s.nextInt();
            farm = new int[size][size];

            s.nextLine();

            for (int i = 0; i < size; i++) {
                String str = s.nextLine();
                for (int j = 0; j < size; j++) {
                    farm[i][j] = Character.getNumericValue(str.charAt(j));
                }
            }

            int start = size / 2;
            int end = size / 2;
            int result = 0;

            for (int i = 0; i < size; i++) {
                for (int j = start; j <= end; j++) {
                    result += farm[i][j];
                }

                if (i < size / 2) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
