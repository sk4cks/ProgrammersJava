import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        // 결과를 저장할 Stack
        // → 이전 값과 비교하면서 중복 제거
        Stack<Integer> stack = new Stack<>();
        
        // 첫 번째 값은 무조건 추가
        stack.push(arr[0]);

        // 배열을 순회
        for(int i=0; i<arr.length; i++) {
            
            // 스택의 마지막 값(이전 값)과 현재 값이 다르면 추가
            // → 같은 값이 연속으로 나오면 무시
            if(stack.peek() != arr[i]) 
                stack.push(arr[i]);
        }

        // Stack → int 배열로 변환
        return stack.stream().mapToInt(i -> i).toArray();
    }
}