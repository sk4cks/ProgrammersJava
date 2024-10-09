import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        while (n > 0){
            pq.add(n%10);
            n /= 10;
        }

        while (!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        answer =  Long.parseLong(sb.toString());
        
        return answer;
    }
}