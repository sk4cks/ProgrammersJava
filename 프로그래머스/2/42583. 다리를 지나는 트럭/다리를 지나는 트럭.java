import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>(Arrays.asList(new Integer[bridge_length]));
        int curWeight = 0;
        int curCount = 0;

        for(int i=0; i<truck_weights.length; i++) {
            while(true) {
                answer++;
                Integer poll = que.poll();
                if(poll != null) {
                    curWeight -= poll;
                    curCount--;
                }

                if(curWeight+truck_weights[i] <= weight && curCount+1 <= bridge_length) {
                    que.add(truck_weights[i]);
                    curWeight += truck_weights[i];
                    curCount++;
                    break;
                }else que.add(null);
            }
        }
        
        answer += bridge_length;
        return answer;
    }
}