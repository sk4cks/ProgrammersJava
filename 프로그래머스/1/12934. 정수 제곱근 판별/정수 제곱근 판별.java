class Solution {
    public long solution(long n) {
        long answer = -1;
        Double sqrt = Math.sqrt(n);

        if(sqrt == sqrt.intValue()) {
            answer = (long) Math.pow(sqrt+1,2);
        }
        
        return answer;
    }
}