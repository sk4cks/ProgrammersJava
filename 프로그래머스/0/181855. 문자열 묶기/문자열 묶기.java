class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] lengthArr = new int[31];
        
        for(int i=0; i<strArr.length; i++) {
            lengthArr[strArr[i].length()]++;
        }
        
        for(int i=0; i<lengthArr.length; i++) {
            answer = Math.max(answer,lengthArr[i]);
        }
        
        return answer;
    }
}