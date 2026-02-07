class Solution {
    public String solution(String new_id) {
        
        // 1단계: 모든 대문자를 소문자로 변환
        String answer = new_id.toLowerCase(); 

        // 2단계: 허용된 문자(알파벳 소문자, 숫자, -, _, .)를 제외한 모든 문자 제거
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        
        // 3단계: 마침표가 2번 이상 연속되면 하나의 마침표로 치환
        answer = answer.replaceAll("[.]{2,}", ".");
        
        // 4단계: 처음이나 끝에 위치한 마침표 제거
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5단계: 빈 문자열이면 "a" 대입
        if(answer.equals("")) answer = "a";
        
        // 6단계: 길이가 16자 이상이면 15자까지만 자르고,
        //       끝에 마침표가 있으면 제거
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        // 7단계: 길이가 2자 이하라면,
        //       마지막 문자를 길이가 3이 될 때까지 반복해서 붙임
        if(answer.length() <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        
        // 최종 아이디 반환
        return answer;
    }
}