class Solution {
    public String solution(String s, int n) {
        
        // 결과 문자열을 만들기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 문자열을 한 글자씩 순회
        for(int i=0; i<s.length(); i++) {
            
            // 현재 문자
            char word = s.charAt(i);

            // 공백은 그대로 유지
            if(word != ' '){
                
                // 기준 문자 (대문자면 'A', 소문자면 'a')
                char ch = 'A';
                
                // 현재 문자가 소문자라면 기준을 'a'로 변경
                if(Character.isLowerCase(word)) ch = 'a';

                // 시저 암호 적용
                // 1. (word - ch) → 알파벳 순서 (0~25)
                // 2. + n → n만큼 이동
                // 3. % 26 → 알파벳 범위 초과 시 순환
                // 4. + ch → 다시 문자로 변환
                word = (char) ((word - ch + n) % 26 + ch);
            }
            
            // 변환된 문자 추가 (공백 포함)
            sb.append(word);
        }
        
        // 최종 문자열 반환
        return sb.toString();
    }
}