import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int curCount = 0;
        Queue<int[]> que = new LinkedList<>();
        
        for(int i=0; i<players.length; i++) {
            //큐 확인해서 뺄꺼 빼고
            if(!que.isEmpty() && que.peek()[0] == i) {
                curCount -= que.poll()[1];
            }

            //현재 사용자 서버 체크
            int diff = ((curCount+1) * m) - players[i];
            if(diff <= 0) {
                int addCount = (-diff / m) + 1;
                answer += addCount;
                curCount += addCount;
                que.add(new int[]{i+k,addCount});
            }
        }
        
        return answer;
    }
}