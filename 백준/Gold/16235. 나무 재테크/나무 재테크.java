
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {0,-1,-1,-1,0,1,1,1};
	
	
	static int N,M,K; //칸 크기, 나무 숫자, k년 
	static ArrayList<Integer>[][] ages;
	static int[][] foods, add;
	static int[][] arr;
	
	static int x,y,z;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ages = new ArrayList[N][N];
		foods = new int[N][N];
		arr = new int[N][N];
		add = new int[N][N];
		
		//초기 세팅
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
				foods[i][j] = 5;
				ages[i][j] = new ArrayList<Integer>();
			}
		}
		
		//M개줄 나무 정보
		for(int i=0; i<M; i++) {
			int y,x,z;
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			z = Integer.parseInt(st.nextToken());
			
			ages[y][x].add(z);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Collections.sort(ages[i][j]);
			}
		}
		
		timePass(0);
		
		int ans = 0;
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ans += ages[i][j].size();
			}
		}
		System.out.println(ans);
	}//main
	

	static void timePass(int year) {
		if(year == K) return;
		
		int[][] rest = new int[N][N];
		
		//봄
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//각 칸의 나무들의 나이에 따라 양분 분배
				for(int k=0; k<ages[i][j].size(); k++) {
					//남은 양분이 충분하면
					if(foods[i][j]>=ages[i][j].get(k)) {
						foods[i][j] -= ages[i][j].get(k);
						ages[i][j].set(k, ages[i][j].get(k)+1);//먹은 나무는 나이 증가
						
					}else {
						rest[i][j] += ages[i][j].get(k)/2; 
						ages[i][j].set(k, 0);
					}
					
				}
			}
		}
		
		//삭제
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=ages[i][j].size()-1; k>=0; k--) {
					if(ages[i][j].get(k) == 0) ages[i][j].remove(k); 
				}
			}
		}
		
		
		//여름
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				foods[i][j] += rest[i][j];
			}
		}
		
		//가을
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<ages[i][j].size(); k++) {
					//나이가 5의 배수면
					if(ages[i][j].get(k)%5==0) {
						for(int dir=0; dir<8; dir++) {
							int ny,nx;
							ny = i+dy[dir];
							nx = j+dx[dir];
							
							if(ny>=0 && ny<N && nx>=0 && nx<N) {
								ages[ny][nx].add(0, 1);
							}
						}
					}
				}
			}
		}
		
		//겨울 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				foods[i][j] += add[i][j];
			}
		}
		
		timePass(year+1);
		
		
	}//timePass

}
