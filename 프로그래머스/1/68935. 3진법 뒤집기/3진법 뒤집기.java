class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

       while (n > 0){
           sb.insert(0,n%3);
           n /= 3;
       }

       for(int i=0; i<sb.length(); i++) {
           answer += 
               Integer.parseInt(String.valueOf(sb.charAt(i))) * (int)Math.pow(3,i);
       }
        
        return answer;
    }
}