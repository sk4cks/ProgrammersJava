import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }

        while ( pq.peek() < K && pq.size()>=2 ){
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + (second*2));
            answer++;
        }

        if(pq.peek() < K) answer = -1;
        return answer;
    }
}