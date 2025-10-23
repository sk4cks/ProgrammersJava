import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 1️⃣ 중요도를 내림차순으로 관리할 우선순위 큐 생성
        // → 항상 가장 높은 우선순위(priorities 값이 큰 것)가 먼저 나옴
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        // 2️⃣ 모든 문서의 중요도를 큐에 삽입
        for(int i=0; i< priorities.length; i++){
            queue.add(priorities[i]);
        }

        // 3️⃣ 인쇄 순서를 찾기 위한 반복
        Loop1 :
            while (!queue.isEmpty()){   // 큐가 빌 때까지 반복
                for(int i=0; i< priorities.length; i++){
                    
                    // 현재 큐에서 가장 높은 중요도 문서와 일치하는 문서를 찾음
                    if(queue.peek()==priorities[i]){
                        queue.poll();   // 그 문서를 인쇄(큐에서 제거)
                        answer++;       // 인쇄 순서 1 증가

                        // 만약 이 문서가 내가 요청한 문서(location)라면 종료
                        if(location==i) break Loop1;
                    }
                }
            }
        
        // 4️⃣ 내가 요청한 문서가 인쇄된 순서를 반환
        return answer;
    }
}