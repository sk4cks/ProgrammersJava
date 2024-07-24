class Solution {
    public int solution(String s) {
         int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            String base = s.substring(0,i);
            int count = 1;
            String result = "";
            for(int j=i; j<=s.length(); j+=i) {
                int endIndex = Math.min(s.length(),j+i);
                String cur = s.substring(j,endIndex);
                if(base.equals(cur)) count++;
                else{
                    if(count > 1 ) result += count;
                    result += base;
                    base = cur;
                    count = 1;
                }
            }
            result += base;
            answer = Math.min(answer,result.length());
        }
        return answer;
    }
}