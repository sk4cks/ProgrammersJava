class Solution {
    public long solution(long n) {
        
        // 기본값: 완전제곱수가 아닐 경우 -1 반환
        long answer = -1;
        
        // n의 제곱근 계산
        Double sqrt = Math.sqrt(n);

        // 제곱근이 정수인지 확인
        // (예: 9 → sqrt=3.0 → 3과 같음 → 완전제곱수)
        if(sqrt == sqrt.longValue()) {
            
            // (√n + 1)^2 계산
            // → 다음 완전제곱수
            answer = (long) Math.pow(sqrt + 1, 2);
        }
        
        return answer;
    }
}