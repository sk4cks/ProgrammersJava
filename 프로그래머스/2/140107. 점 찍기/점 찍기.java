class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long powD = (long) d * d;   // d^2 값을 미리 계산 (반복문 안에서 매번 계산하지 않기 위함)

        // x 좌표를 0부터 d까지 k 간격으로 증가
        for(long x=0; x<=d; x+=k) {
            
            // 원의 방정식: x^2 + y^2 <= d^2
            // 현재 x 값에서 가능한 최대 y 값을 계산
            long maxY = (long) Math.sqrt(powD - (long) x * x);
            
            // y는 0부터 maxY까지 k 간격으로 가능
            // (maxY / k) + 1 : y = 0 포함
            answer += maxY/k + 1;
        }
        
        // 조건을 만족하는 모든 (x, y) 좌표 개수 반환
        return answer;
    }
}