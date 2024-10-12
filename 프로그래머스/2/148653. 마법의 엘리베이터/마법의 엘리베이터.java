public class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int remainder = storey % 10;  // 현재 자리 숫자
            
            if (remainder > 5) {
                // 반올림 처리: +1을 해서 다음 자릿수로 올림
                answer += 10 - remainder;
                storey += 10 - remainder;
            } else if (remainder == 5 && (storey / 10) % 10 >= 5) {
                // 다음 자리수가 5 이상이면 반올림 처리
                answer += 10 - remainder;
                storey += 10 - remainder;
            } else {
                // 그냥 처리
                answer += remainder;
            }
            
            storey /= 10;  // 다음 자릿수로 넘어감
        }
        
        return answer;
    }
}
