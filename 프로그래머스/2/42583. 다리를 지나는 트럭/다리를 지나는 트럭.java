import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 총 걸린 시간
        
        // 다리를 표현하는 큐 (bridge_length 칸)
        // 초기에는 모두 비어 있으므로 null로 채운다.
        Queue<Integer> que = new LinkedList<>(Arrays.asList(new Integer[bridge_length]));
        
        int curWeight = 0;  // 현재 다리 위 트럭들의 총 무게
        int curCount = 0;   // 현재 다리 위 트럭 수

        // 모든 트럭을 순서대로 올리기 위한 반복
        for(int i=0; i<truck_weights.length; i++) {
            while(true) {
                answer++;   // 1초 증가
                
                Integer poll = que.poll();  // 매 초마다 다리에서 맨 앞 칸(가장 오래 있는 위치)이 빠져나감
                if(poll != null) {
                    curWeight -= poll;  // 트럭이 나가면 무게 감소
                    curCount--;         // 트럭 수 감소
                }

                // 새로운 트럭이 올라갈 수 있는 조건 검사
                // 1. 현재 무게 + 새로운 트럭 무게 <= 다리 최대 무게
                // 2. 다리 칸 수를 초과하지 않음
                if(curWeight+truck_weights[i] <= weight && curCount+1 <= bridge_length) {
                    // 트럭을 다리에 올림
                    que.add(truck_weights[i]);
                    curWeight += truck_weights[i];
                    curCount++;
                    break;  // 조건을 충족했으니 다음 트럭으로 이동
                    
                // 트럭을 못 올리면 빈 칸(null)을 넣어서 한 칸 전진만 시킴
                } else {
                    que.add(null);
                }
            }
        }
        
        // 마지막 트럭이 다리를 완전히 빠져나가는 데 필요한 시간 추가
        answer += bridge_length;
        
        return answer;
    }
}