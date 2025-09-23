import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;     // 총 추가한 서버 수
        int curCount = 0;   // 현재 켜져 있는 서버 수
        Queue<int[]> que = new LinkedList<>();
        // que: {만료 시각, 추가된 서버 개수}
        // → k 시간 뒤에 해당 서버 수만큼 빠짐
        
        for(int i=0; i<players.length; i++) {
            // 1. 현재 시각에 만료된 서버가 있으면 제거
            if(!que.isEmpty() && que.peek()[0] == i) {
                curCount -= que.poll()[1];
            }

            // 2. 현재 시각에 필요한 사용자 수(players[i]) 확인
            //    현재 서버(curCount)가 처리할 수 있는 최대 사용자 수 = curCount * m
            //    diff = (현재 서버 용량) - (실제 사용자 수)
            //    단, 최소 1대는 기본 서버가 있으므로 (curCount+1)*m 사용
            int diff = ((curCount+1) * m) - players[i];
            
            // 3. 만약 diff <= 0 → 현재 서버 수로는 부족
            if(diff <= 0) {
                // 필요한 서버 수 계산
                // (-diff/m) → 몇 대 부족한지, +1 은 나머지 처리 위해
                int addCount = (-diff / m) + 1;
                
                // 총 추가 서버 수 증가
                answer += addCount;
                
                // 현재 켜져 있는 서버 수 증가
                curCount += addCount;
                
                // k 시간 뒤에 addCount 서버 만료 → 큐에 등록
                que.add(new int[]{i+k,addCount});
            }
        }
        
        return answer;
    }
}