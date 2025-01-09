class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        
        for(int i=0; i<box.length; i++) {
            box[i] = (box[i]/n) * n;
            answer *= box[i];
        }
        
        answer /= Math.pow(n,3);
        
        return answer;
    }
}