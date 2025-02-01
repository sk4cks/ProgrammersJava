class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean isEven = n%2 == 0;

        while (n > 0) {
            if(isEven) answer += Math.pow(n,2);
            else answer += n;

            n -= 2;
        }
        
        return answer;
    }
}