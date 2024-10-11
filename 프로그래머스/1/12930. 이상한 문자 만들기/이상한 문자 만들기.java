class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(int i=0; i<s.length(); i++) {
            char word = s.charAt(i);

            cnt = word == ' ' ? 0 : cnt+1;

            if(cnt%2 == 0) sb.append(String.valueOf(word).toLowerCase());
            else sb.append(String.valueOf(word).toUpperCase());
        }
        
        answer = sb.toString();
        return answer;
    }
}