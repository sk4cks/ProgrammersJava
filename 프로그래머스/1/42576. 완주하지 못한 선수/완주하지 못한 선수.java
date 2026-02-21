import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 완주한 선수들의 이름과 등장 횟수를 저장할 맵
        Map<String,Integer> map = new HashMap<>();

        // completion 배열을 순회하면서
        // 완주한 선수의 이름을 카운트
        for(int i=0; i<completion.length; i++) {
            map.put(completion[i],
                    map.getOrDefault(completion[i],0) + 1);
        }
        
        // 참가자 목록을 순회
        for(int i=0; i< participant.length; i++){
            
            // 해당 참가자의 남은 카운트를 1 감소
            int count = map.getOrDefault(participant[i],0) - 1;
            map.put(participant[i], count);

            /*
             count가 음수가 되었다는 것은
             completion에 없는 참가자이거나
             이미 카운트를 모두 사용한 경우
             
             → 즉, 완주하지 못한 선수
            */
            if(count < 0) {
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}