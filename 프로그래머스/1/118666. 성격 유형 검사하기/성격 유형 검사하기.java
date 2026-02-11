import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        // 성격 유형 순서 (짝으로 비교됨)
        // R-T, C-F, J-M, A-N
        char[] type = {'R','T','C','F','J','M','A','N'};
        
        // 각 성격 유형별 점수를 저장할 맵
        Map<Character,Integer> map = new HashMap<>();

        // 모든 성격 유형의 초기 점수를 0으로 세팅
        for(int i=0; i<type.length; i++){
            map.put(type[i],0);
        }

        // 설문 문항 하나씩 처리
        for(int i=0; i<survey.length; i++){
            
            /*
             choices 값 의미
             1 2 3 4 5 6 7
             매우비동의  ...  매우동의
             
             4는 중립 (점수 없음)
             1~3은 survey[i]의 첫 번째 성격 유형에 점수
             5~7은 survey[i]의 두 번째 성격 유형에 점수
            */
            
            // choices가 4보다 크면 두 번째 유형, 아니면 첫 번째 유형
            int index = choices[i] > 4 ? 1 : 0;
            
            // 점수를 받을 성격 유형
            char target = survey[i].charAt(index);
            
            // 점수 계산
            // 예: choices가 1이면 3점, 2이면 2점, 3이면 1점
            // 예: choices가 5이면 1점, 6이면 2점, 7이면 3점
            int score = index == 0 ? 4 - choices[i] : choices[i] - 4;
            
            // 해당 성격 유형에 점수 누적
            map.put(target, map.get(target) + score);
        }

        // 각 성격 유형을 짝으로 비교하여 더 높은 점수를 가진 유형 선택
        for(int i=0; i<type.length; i+=2){
            // 점수가 같으면 사전순(앞에 있는 문자) 선택
            answer += map.get(type[i]) >= map.get(type[i+1]) ? type[i] : type[i+1];
        }
        
        return answer;
    }
}