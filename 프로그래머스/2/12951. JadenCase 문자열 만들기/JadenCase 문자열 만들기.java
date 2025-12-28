class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(); // 결과 문자열을 저장할 StringBuilder
        
        // 단어의 첫 글자인지 여부를 판단하는 플래그
        // true면 다음 문자는 단어의 첫 글자
        boolean flag = true;

        // 문자열을 한 글자씩 순회
        for(int i=0; i<s.length(); i++){
            
            // 현재 문자를 문자열로 변환 후 소문자로 통일
            String word =  String.valueOf(s.charAt(i)).toLowerCase();
            
            // 공백을 만나면 다음 문자가 단어의 첫 글자가 됨
            if(word.equals(" ")) flag = true;
            
            // 단어의 첫 글자인 경우
            else if(flag) {
                word = word.toUpperCase();  // 첫 글자는 대문자로 변환
                flag = false;   // 이후 문자는 첫 글자가 아님
            }
            
            // 변환된 문자를 결과에 추가
            sb.append(word);
        }
        
        // 변환 완료된 문자열 반환
        return sb.toString();
    }
}