class Solution {
    public int solution(String s) {
        char tmp = s.charAt(0);
        int sameCount = 1;
        int differentCount = 0;
        int answer = 1;
        
        for(int i=1; i<s.length(); i++){
            if(tmp==s.charAt(i)) sameCount++;
            else differentCount++;

            if(sameCount==differentCount) {
                i++;
                if(i < s.length()){
                    tmp = s.charAt(i);
                    differentCount = 0;
                    sameCount = 1;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}