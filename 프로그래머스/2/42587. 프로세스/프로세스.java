import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i< priorities.length; i++){
            queue.add(priorities[i]);
        }

        Loop1 :
            while (!queue.isEmpty()){
                for(int i=0; i< priorities.length; i++){
                    if(queue.peek()==priorities[i]){
                        queue.poll();
                        answer++;

                        if(location==i) break Loop1;
                    }
                }
            }
        return answer;
    }
}