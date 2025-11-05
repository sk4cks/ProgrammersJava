import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 🔸 최소 힙(Min-Heap) : 항상 가장 작은 값이 맨 앞에 오도록 유지
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 모든 음식의 스코빌 지수를 우선순위 큐에 삽입
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }

        // 🔸 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복
        //     - 가장 낮은 2개의 음식을 꺼내서 새로운 음식으로 섞음
        //     - pq.peek() : 가장 작은 값 확인
        //     - pq.size() >= 2 : 최소 2개 이상일 때만 섞을 수 있음
        while ( pq.peek() < K && pq.size()>=2 ){
            int first = pq.poll();  // 가장 맵지 않은 음식 (첫 번째)
            int second = pq.poll(); // 두 번째로 맵지 않은 음식
            
            // 새로 만든 음식의 스코빌 지수 계산
            // (섞은 음식의 스코빌 = 가장 낮은 음식 + (두 번째 음식 * 2))
            pq.add(first + (second*2));
            
            answer++;   // 섞은 횟수 증가
        }

        // 🔸 반복이 끝난 후에도 가장 작은 스코빌 지수가 K 미만이면 불가능
        if(pq.peek() < K) answer = -1;
        
        // 총 섞은 횟수 반환
        return answer;
    }
}