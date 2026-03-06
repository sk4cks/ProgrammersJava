class Solution {
    public int solution(String[] babbling) {
        // 발음할 수 있는 단어 목록
        String[] list = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;  // 조건을 만족하는 단어 개수
        
        // babbling 배열에 있는 각 단어 검사
        for(int i = 0; i < babbling.length; i++){
            
            // 검사할 문자열
            String s = babbling[i];
            
            // 발음 가능한 단어 4개를 하나씩 확인
            for(int j = 0; j < list.length; j++){
                
                /*
                 같은 발음이 연속으로 나오는지 검사
                 예: "ayaaya", "yeye" 등
                 이런 경우는 허용되지 않으므로 검사 중단
                */
                if(s.indexOf(list[j] + list[j]) != -1) 
                    break;
                
                /*
                 해당 발음이 문자열에 있으면
                 공백으로 치환
                 
                 예:
                 "ayawoo" → " woo" → "  "
                */
                s = s.replaceAll(list[j], " ");
            }
            
            // 공백 제거
            s = s.replaceAll(" ", "");
            
            /*
             모든 발음이 정상적으로 제거되었다면
             문자열이 빈 문자열이 됨
            */
            if(s.equals("")) 
                answer++;
        }
        
        // 조건을 만족하는 단어 개수 반환
        return answer;
    }
}