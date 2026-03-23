import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        // 매일의 명예의 전당 최저 점수를 저장할 배열
        int[] answer = new int[score.length];
        
        // 우선순위 큐 (최소 힙)
        // → 가장 작은 값이 항상 맨 앞에 위치
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 날짜별 점수를 순회
        for(int i=0; i<score.length; i++){
            
            // 오늘 점수를 큐에 추가
            pq.offer(score[i]);
            
            // 명예의 전당 크기가 k를 초과하면
            if(pq.size() > k) 
                // 가장 작은 값 제거 (최하위 탈락)
                pq.poll();
            
            // 현재 명예의 전당에서 가장 낮은 점수
            // → 최소 힙이므로 peek()가 최솟값
            answer[i] = pq.peek();
        }
        
        // 결과 반환
        return answer;
    }
}