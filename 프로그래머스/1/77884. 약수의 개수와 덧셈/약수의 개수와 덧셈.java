class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        // left부터 right까지 모든 수를 순회
        for(int i = left; i <= right; i++){
            
            // i의 제곱근 계산
            double sqrt = Math.sqrt(i);
            
            // 제곱근이 정수라면 → 완전제곱수
            // (약수의 개수가 홀수)
            if(sqrt == (int)sqrt) 
                // 완전제곱수는 빼기
                answer -= i;
            else 
                // 그 외는 더하기
                answer += i;
        }
        
        return answer;
    }
}