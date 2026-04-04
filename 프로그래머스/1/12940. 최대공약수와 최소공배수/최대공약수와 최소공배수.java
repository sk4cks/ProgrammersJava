class Solution {
    public int[] solution(int n, int m) {
        
        // 결과 배열
        // answer[0] = 최대공약수(GCD)
        // answer[1] = 최소공배수(LCM)
        int[] answer = new int[2];
        
        // 최대공약수 구하기 (유클리드 호제법)
        int g = gcd(n, m);
        
        // 최소공배수 공식
        // LCM = (n * m) / GCD
        int c = (n * m) / g; 
        
        // 결과 저장
        answer[0] = g;
        answer[1] = c;
        
        return answer;
    }
    
    // 최대공약수(GCD) 구하는 함수 (유클리드 호제법)
    private static int gcd(int a, int b) {
        
        // a를 b로 나눈 나머지
        int r = a % b;
        
        // 나머지가 0이면 b가 최대공약수
        if(r == 0) return b;
        
        // 아니라면 (b, r)로 다시 계산
        else return gcd(b, r);
    }
}