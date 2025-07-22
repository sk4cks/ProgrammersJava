class Solution {
    public long solution(int w, int h) {
        int gcd = getGcd(w,h);
        
        return ((long) w * h) - (w/gcd + h/gcd -1) * gcd;
    }
    
    int getGcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
}