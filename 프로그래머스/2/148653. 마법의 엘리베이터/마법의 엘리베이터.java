public class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey>0){
            int remainder = storey%10;
            
            if(remainder >5){
                answer = answer + 10 - remainder;
                storey = storey + 10 - remainder;
            }else if(remainder == 5 && (storey/10)%10 >=5){ // 145 -> 140 -> 100 (9), 165 -> 170 -> 200 -> 100(10)
                answer += 5;
                storey += 5;
            }else {
                answer += remainder;
                storey -= remainder;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}