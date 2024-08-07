import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0,index=0; i< order.length; i++){
            if(order[index] == i+1){
                answer++;
                index++;
            }
            else stack.push(i+1);
            while(!stack.isEmpty() && stack.peek()==order[index]){
              stack.pop();
              answer++;
              index++;
            }
        }
        return answer;
    }
}