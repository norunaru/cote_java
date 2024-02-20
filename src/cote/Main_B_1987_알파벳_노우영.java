package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 메모리 12436kb
 시간 864ms
 */
public class Main_B_1987_알파벳_노우영 {
	static int R, C;
	static char[][] arr;
	static int cnt;
	static boolean[] abc; //알파벳 A~Z를 사용 여부 저장용 배열, 사이즈 26

	static int result = 0;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}


		abc = new boolean[26];
		abc[arr[0][0]-65] = true; //0,0 인덱스(시작점)의 알파벳 사용했다고 표시
		dfs(0, 0, 1);

		System.out.println(result);

	}// main

	private static void dfs(int y, int x, int cnt) {
		if (cnt > result) //카운트가 현재 저장된 최종 결과값보다 크면 대체
			result = cnt;

		//현재 알파벳 사용했다고 표시


		for (int i = 0; i < 4; i++) { //사방탐색해서 다음 자리가 범위 내에 있고, 사용하지 않은 알파벳이멘 dfs
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < R && nx >= 0 && nx < C && abc[arr[ny][nx] - 65] == false) {
				abc[(int) arr[ny][nx] - 65] = true;
				dfs(ny, nx, cnt + 1);
				abc[(int) arr[ny][nx] - 65] = false;
			}
		}


		//		return;
	}// dfs

}