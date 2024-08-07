import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<= order.length; i++){
            que.add(i);
        }


        for(int i=0; i< order.length; i++){
            while(true){
                if(!que.isEmpty() && que.peek() != order[i] && (stack.isEmpty() || stack.peek() != order[i])){
                    stack.push(que.poll());
                }else if(!que.isEmpty() && que.peek() == order[i]){
                    que.poll();
                    answer++;
                    break;
                }else if(!stack.isEmpty() && stack.peek() == order[i]){
                    stack.pop();
                    answer++;
                    break;
                }else if(que.isEmpty() && stack.peek() != order[i]){
                    return answer;
                }
            }
        }
        return answer;
    }
}