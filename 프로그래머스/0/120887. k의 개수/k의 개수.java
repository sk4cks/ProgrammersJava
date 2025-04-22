class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(i=i; i<=j; i++) {
            String str = String.valueOf(i);
            answer += str.length() - str.replace(String.valueOf(k), "").length();
        }
        
        return answer;
    }
}