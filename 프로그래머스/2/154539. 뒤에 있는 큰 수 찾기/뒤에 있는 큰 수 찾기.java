import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();   // 🔹 인덱스를 저장할 스택 (값이 아니라 '위치'를 넣는다)
        int[] answer = new int[numbers.length]; // 🔹 결과를 저장할 배열
        stack.push(0);  // 🔹 첫 번째 인덱스(0)를 스택에 미리 넣는다
        
        // 🔹 numbers 배열 순회
        for(int i=0; i<numbers.length; i++){
            
            // ✅ 현재 수(numbers[i])가 스택 top에 있는 인덱스의 값보다 크면
            // 그 인덱스의 "뒤에 있는 큰 수"를 현재 값으로 기록
            while(!stack.isEmpty()&& numbers[stack.peek()] < numbers[i]){
                // 스택에서 꺼낸 인덱스 위치에 현재 수를 넣음
                answer[stack.pop()] = numbers[i];
            }
            
            // 현재 인덱스를 스택에 넣음 (아직 뒤에 더 큰 수를 못찾음)
            stack.push(i);
        }
        
        // 🔹 스택에 남은 인덱스들은 뒤에 더 큰 수가 없는 경우이므로 -1로 설정
        while (!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        
        // 🔹 결과 반환
        return answer;
    }
}