public class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int remainder = storey%10;
            
            //현재 자리수가 6,7,8,9
            if(remainder > 5){
                storey = storey + 10 - remainder;
                answer = answer + 10 - remainder;
            }else if (remainder==5 && (storey/10)%10>=5){ //195 -> 200, 105 -> 100
                answer += remainder;
                storey += remainder;
            }else { //0,1,2,3,4
                answer += remainder; 
                // storey -= remainder;
            }
            storey /= 10;
        }//while
        
        return answer;
    }
}