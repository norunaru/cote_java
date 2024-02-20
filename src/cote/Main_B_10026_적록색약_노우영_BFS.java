package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
/*
 메모리 13052kb
 시간 104ms
 */
public class Main_B_10026_적록색약_노우영_BFS {
	
	
	static class Node{
		int y;
		int x;
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] arr1 = new char[N][N];//정상인
		char[][] arr2 = new char[N][N];//색약
		
		int R1=0,G1=0,B1=0,R2=0,B2=0;
		int result1, result2;
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		
		//배열만들기
		for(int i=0; i<N; i++) {
			String current = br.readLine();
			for(int j=0; j<N; j++) {
				arr1[i][j] = current.charAt(j);
				
				if(current.charAt(j)=='R' || current.charAt(j)=='G') {
					arr2[i][j] = 'R';
				}else {
					arr2[i][j] = current.charAt(j);
				}
			}
		}
		
		//입력 확인
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(arr1[i]));
//		}
//		System.out.println();
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(arr2[i]));
//		}
		Queue<Node> queue1 = new ArrayDeque<>();
		Queue<Node> queue2 = new ArrayDeque<>();
		
		char color1, color2;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//rgb중 하나가 나오면 카운트 증가
				if(arr1[i][j] != 'A') {
					color1 = arr1[i][j];
					//rgb에 따라 카운트 증가
					if(color1 == 'R') R1++;
					else if(color1 == 'G') G1++;
					else if(color1 == 'B') B1++;
					
					arr1[i][j] = 'A';
					queue1.offer(new Node(i,j));

					//bfs
					while(!queue1.isEmpty()) {
						Node current = queue1.poll();
						
						for(int a=0; a<4; a++) {
							int ny = current.y + dy[a];
							int nx = current.x + dx[a];
							if(ny>=0 && ny<N && nx>=0 && nx<N && arr1[ny][nx]==color1) {
								arr1[ny][nx] = 'A';
								queue1.offer(new Node(ny,nx));
							}
						}
						
					}
				}
				if(arr2[i][j] != 'A') {
					color2 = arr2[i][j];
					//rgb에 따라 카운트 증가
					if(color2 == 'R') R2++;
					else if(color2 == 'B') B2++;
//					else if(color2 == 'G') G2++;
					
					arr2[i][j] = 'A';
					queue2.offer(new Node(i,j));

					//bfs
					while(!queue2.isEmpty()) {
						Node current = queue2.poll();
						
						for(int a=0; a<4; a++) {
							int ny = current.y + dy[a];
							int nx = current.x + dx[a];
							if(ny>=0 && ny<N && nx>=0 && nx<N && arr2[ny][nx]==color2) {
								arr2[ny][nx] = 'A';
								queue2.offer(new Node(ny,nx));
							}
						}
						
					}
				}
				
			}
		}
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				//rgb중 하나가 나오면 카운트 증가
//				if(arr1[i][j] != 'A') {
//					color1 = arr1[i][j];
//					//rgb에 따라 카운트 증가
//					if(color1 == 'R') R1++;
//					else if(color1 == 'G') G1++;
//					else if(color1 == 'B') B1++;
//					
//					arr1[i][j] = 'A';
//					queue1.offer(new Node(i,j));
//
//					//bfs
//					while(!queue1.isEmpty()) {
//						Node current = queue1.poll();
//						
//						for(int a=0; a<4; a++) {
//							int ny = current.y + dy[a];
//							int nx = current.x + dx[a];
//							if(ny>=0 && ny<N && nx>=0 && nx<N && arr1[ny][nx]==color1) {
//								arr1[ny][nx] = 'A';
//								queue1.offer(new Node(ny,nx));
//							}
//						}
//						
//					}
//				}
//				
//			}
//		}
		
		
		
		
		
		result1 = R1+G1+B1;
		result2 = R2+B2;
		System.out.println(result1+" " + result2);
		
		
	}//main
	
	
	

}