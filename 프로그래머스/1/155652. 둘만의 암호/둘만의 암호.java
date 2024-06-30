class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int copyIndex = index;
            for(int j=0; j<copyIndex; j++){
                c++;
                if(c > 122) c = 97;
                if(skip.indexOf(c)!=-1) copyIndex++;

            }
            answer += c;
        }
        
        return answer;
    }
}