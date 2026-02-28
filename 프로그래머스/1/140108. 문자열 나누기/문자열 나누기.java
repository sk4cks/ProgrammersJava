class Solution {
    public int solution(String s) {
        
        // 기준이 되는 문자 (처음 문자)
        char tmp = s.charAt(0);
        
        // 기준 문자와 같은 문자 개수
        int sameCount = 1;
        
        // 기준 문자와 다른 문자 개수
        int differentCount = 0;
        
        // 최소 1개의 문자열은 존재
        int answer = 1;
        
        // 두 번째 문자부터 탐색
        for(int i = 1; i < s.length(); i++){
            
            // 기준 문자와 같으면 sameCount 증가
            if(tmp == s.charAt(i)) 
                sameCount++;
            else 
                differentCount++;
            
            /*
             같은 문자 개수와 다른 문자 개수가 같아지면
             하나의 문자열 분리 완료
            */
            if(sameCount == differentCount) {
                
                // 다음 문자로 이동
                i++;
                
                // 아직 문자열이 남아있다면
                if(i < s.length()){
                    
                    // 새로운 기준 문자 설정
                    tmp = s.charAt(i);
                    
                    // 카운트 초기화
                    differentCount = 0;
                    sameCount = 1;
                    
                    // 분리된 문자열 개수 증가
                    answer++;
                }
            }
        }
        
        return answer;
    }
}