import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();

        for(int i=0; i< priorities.length; i++){
            que.add(new int[]{i, priorities[i]});
        }

        while (!que.isEmpty()){
            int[] priority = que.poll();
            if(que.stream().anyMatch(o -> o[1] > priority[1])){
                que.add(priority);
            }else{
                answer++;
                if(priority[0] == location) break;
            }
        }
        return answer;
    }
}