import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0; // 최대로 방어할 수 있는 라운드 수
        // 내림차순 우선순위 큐 생성 (큰 값이 먼저 나오도록)
        PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder());

        // 적의 공격 배열을 순회
        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];  // 남은 병사 수에서 이번 라운드 적의 수만큼 차감
            pque.add(enemy[i]); // 이번 라운드 적의 수를 우선순위 큐에 추가

            // 만약 병사가 부족하면
            if (n < 0) {
                
                // 무적권(k)을 사용 가능한 경우
                if (k > 0) {
                    // 가장 큰 적 수 라운드를 무적권으로 처리
                    n += pque.poll();   // 병사 수를 다시 복구
                    k--;    // 무적권 사용
                    
                // 무적권도 없으면 더 이상 방어 불가
                } else {
                    break;
                }
            }
            
            // 방어 성공한 라운드 수 증가
            answer++;
        }
        
        // 최종 방어 가능한 라운드 수 반환
        return answer;
    }
}