class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int tmp = 0;
        for(int i=0; i<section.length; i++){
            if(tmp > section[i]) continue;
            else{
                tmp = section[i]+m;
                answer++;
            }
        }
        return answer;
    }
}