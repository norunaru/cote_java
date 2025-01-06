import java.util.*;
class Solution {
    static Queue<Integer> queue = new ArrayDeque<Integer>();
    static List<Integer> list = new ArrayList<Integer>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        
        for(int i=0; i<N; i++){
            int cnt = 0;
            
            while(100 > progresses[i] + cnt*speeds[i]){
                cnt++;
            }
            queue.offer(cnt);
        }
        
        System.out.println(queue);
        
        while(!queue.isEmpty()){
            int cnt = 1;
            int cur = queue.poll();
            
            while(!queue.isEmpty() &&  queue.peek() <= cur){
                queue.poll();
                cnt++;
            }
            list.add(cnt);
        }
        System.out.println(list.size());
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        
        
        int[] answer = {};
        return ans;
    }
}