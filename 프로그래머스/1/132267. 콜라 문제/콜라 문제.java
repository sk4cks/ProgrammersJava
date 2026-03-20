class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        // n이 a보다 크거나 같을 때까지 반복
        // (빈 병 a개를 모아야 교환 가능)
        while (n >= a){
            
            // 현재 가지고 있는 빈 병 n개로 교환 가능한 콜라 수 계산
            // (n / a) : 교환 횟수
            // (n / a) * b : 새로 받는 콜라 병 수
            answer += (n / a) * b;
            
            // 교환 후 남은 병 업데이트
            // (n / a) * b : 새로 받은 콜라 → 다 마시면 빈 병이 됨
            // (n % a) : 교환하고 남은 빈 병
            n = ((n / a) * b) + (n % a);
        }
        
        // 총 받은 콜라 병 수 반환
        return answer;
    }
}