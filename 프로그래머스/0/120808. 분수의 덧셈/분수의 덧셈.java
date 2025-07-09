class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        answer[1] = lcm(denom1, denom2);
        
        numer1 = numer1 * (answer[1]/denom1);
        numer2 = numer2 * (answer[1]/denom2);
        answer[0] = numer1 + numer2;
        
        int gcd = getGcd(answer[0],answer[1]);
        
        answer[0] /= gcd;
        answer[1] /= gcd;
        
        return answer;
    }
    
    public int lcm(int a, int b) {
        return (a * b) / getGcd(a, b);
    }
    
    public int getGcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}