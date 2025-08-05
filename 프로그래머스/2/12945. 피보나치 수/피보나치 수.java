import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n) {
        Queue<Integer> que = new LinkedList<>();
        int answer = 0;
        int index = 0;
        
        que.add(0);
        que.add(1);

        while (index < n){
            index++;
            que.add((que.poll() + que.peek()) % 1234567);
        }
        
        answer = que.peek();
        
        return answer;
    }
}