import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pque.add(enemy[i]);

            if(n < 0) {
                if(k > 0) {
                    n += pque.poll();
                    k--;
                }else{
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}