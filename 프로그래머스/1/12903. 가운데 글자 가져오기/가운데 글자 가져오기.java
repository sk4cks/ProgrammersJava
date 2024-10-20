class Solution {
    public String solution(String s) {
        String answer = "";
        int quotient = s.length()/2;

        if(s.length()%2==0) answer += s.charAt(quotient-1);
        answer += s.charAt(quotient);
        
        return answer;
    }
}