import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        // 최대 힙 (내림차순 정렬)
        // → 큰 숫자가 먼저 나오도록 설정
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 결과 문자열을 만들기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 숫자를 한 자리씩 분리
        while (n > 0){
            
            // 마지막 자리 추출 (n % 10)
            pq.add(n % 10);
            
            // 다음 자리로 이동
            n /= 10;
        }

        // 우선순위 큐에서 하나씩 꺼내면서 (큰 값부터)
        while (!pq.isEmpty()){
            
            // 문자열에 이어붙이기
            sb.append(pq.poll());
        }
        
        // 문자열을 long 타입으로 변환
        answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}