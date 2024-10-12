/*
1번~n번의 n명이 끝말잇기
마지막 사람이 말하면 다시 1번부터
이전에 등장한 단어 사용 불가
<한 글자 단어 인정 x>
가장 먼저 탈락하는 사람의 번호, 자신의 몇 번째 차례에 탈락하는지 리턴
----------------------------------------------------------------
프로세스 : 
for문으로 word하나씩 사용, i%n==0이면 round++
turn 1씩 증가(0 ~ n-1)
이전 단어의 마지막 글자 prev, 시작시 첫 단어의 마지막 글자로 놓고 시작
해시맵 사용, 단어가 들어 있으면 break, turn+1, round 리턴

*/
import java.util.HashMap;
class Solution {
    static HashMap<String, Integer> hmap = new HashMap<String,Integer>();
    
    public int[] solution(int n, String[] words) {
        int round; // 몇 바퀴
        int turn  = 0; // 0 ~ n-1, 사람 번호
        int[] answer = new int[2];
        char prev = words[0].charAt(0);
        
        System.out.println(prev);
        
        for(int i=0; i<words.length; i++){
            round = i/n + 1;
            turn = i%n;
            String word = words[i];
            
            if(hmap.containsKey(word) || prev!=word.charAt(0)){
                answer[0] = turn+1;
                answer[1] = round;
                return answer;
            }
            
            hmap.put(word, 0);
            
            prev = word.charAt(word.length() - 1);
            
            System.out.println(word+" "+ prev);
            
        }    
        
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}








