import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 현재까지 사용한 예산 합
        int total = 0;
        
        // 요청 금액을 오름차순 정렬
        // → 작은 금액부터 처리해야 더 많은 부서를 지원 가능
        Arrays.sort(d);

        // 부서 요청을 하나씩 확인
        for(int i=0; i<d.length; i++){
            
            // 현재 부서 지원 시 예산 누적
            total += d[i];
            
            // 예산을 초과하면
            if(total > budget) 
                // 현재 부서는 지원 불가 → 이전 개수(i개)가 최대
                return i;
        }
        
        // 모든 부서를 지원할 수 있는 경우
        answer = d.length;
        
        return answer;
    }
}