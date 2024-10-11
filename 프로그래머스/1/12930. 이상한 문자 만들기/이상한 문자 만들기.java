class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(int i=0; i<s.length(); i++) {
            char word = s.charAt(i);
            
            if(word == ' ') {
                cnt = 0;
                sb.append(word);
                continue;
            }
            
            if(cnt%2 == 0) sb.append(String.valueOf(word).toUpperCase());
            else sb.append(String.valueOf(word).toLowerCase());
            cnt++;
        }
        
        answer = sb.toString();
        return answer;
    }
}