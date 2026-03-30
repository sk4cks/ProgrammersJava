class Solution {
    public String solution(String s) {
        
        // 최종 결과 문자열
        String answer = "";
        
        // 문자열을 효율적으로 만들기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 현재 단어에서의 문자 위치 (공백 기준으로 초기화됨)
        int cnt = 0;
        
        // 문자열을 한 글자씩 순회
        for(int i=0; i<s.length(); i++) {
            
            // 현재 문자
            char word = s.charAt(i);

            // 공백이면 단어가 끊기므로 cnt 초기화
            // 공백이 아니면 인덱스 증가
            cnt = word == ' ' ? 0 : cnt + 1;

            // 홀수 번째 문자 → 대문자
            if(cnt % 2 == 1) {
                sb.append(String.valueOf(word).toUpperCase());
            }
            // 짝수 번째 문자 → 소문자
            else {
                sb.append(String.valueOf(word).toLowerCase());
            }
        }
        
        // StringBuilder → String 변환
        answer = sb.toString();
        
        return answer;
    }
}