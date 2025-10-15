import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;     // 트럭에 실은 상자의 개수
        Stack<Integer> stack = new Stack<>();   // 보조 컨테이너 벨트 (임시 저장용)

        // i: 현재 메인 벨트에서 오는 상자 번호 (1부터 시작)
        // index: 현재 트럭에 실어야 하는 상자의 순서 (order 배열 인덱스)
        for(int i=0,index=0; i< order.length; i++){
            
            // 1️⃣ 메인 벨트에서 상자 하나 도착
            // 벨트에서 오는 상자 번호는 i+1 (예: i=0이면 1번 상자)
            // 만약 지금 실어야 하는 상자(order[index])와 같다면 → 바로 트럭에 실음
            if(order[index] == i+1){
                answer++;
                index++;
            }
            else stack.push(i+1);   // 2️⃣ 아니라면, 순서가 아니므로 보조 컨테이너에 잠시 쌓음
            
            // 3️⃣ 보조 컨테이너(stack)에서 상자를 꺼낼 수 있는지 확인
            // 스택이 비어있지 않고, top(맨 위) 상자가 현재 필요한 상자라면
            // 계속 꺼내서 트럭에 실음
            while(!stack.isEmpty() && stack.peek()==order[index]){
              stack.pop();
              answer++;
              index++;
            }
        }
        
        // 최종적으로 실은 상자 개수 반환
        return answer;
    }
}