class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long powD = (long) d * d;

        for(long x=0; x<=d; x+=k) {
            long maxY = (long) Math.sqrt(powD - (long) x * x);
            answer += maxY/k + 1;
        }
        
        return answer;
    }
}