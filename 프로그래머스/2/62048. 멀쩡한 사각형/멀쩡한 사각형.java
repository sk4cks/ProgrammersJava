class Solution {
    public long solution(int w, int h) {
        int gcd = getGcd(w,h);  // w와 h의 최대공약수(GCD)를 구함
        
        /*
         * 전체 사각형 개수 = w * h
         * 
         * 대각선이 지나가면서 잘리는 사각형 개수는
         * (w/gcd + h/gcd - 1) * gcd
         * 
         * 이유:
         * - w/gcd, h/gcd 로 나누면 서로소인 최소 사각형 블록이 됨
         * - 그 블록에서 대각선이 지나는 사각형 수는 (w/gcd + h/gcd - 1)
         * - 이런 블록이 gcd개 만큼 반복됨
         */
        return ((long) w * h) - (w/gcd + h/gcd -1) * gcd;
    }
    
    // 유클리드 호제법을 이용한 최대공약수(GCD) 계산
    int getGcd(int a, int b) {
        // b가 0이 될 때까지 반복
        while (b != 0) {
            int temp = b;   // b 값을 임시 저장
            b = a % b;      // a를 b로 나눈 나머지
            a = temp;       // a에 이전 b 값 대입
        }
        
        return a;   // b가 0이 되면 a가 최대공약수
    }
}