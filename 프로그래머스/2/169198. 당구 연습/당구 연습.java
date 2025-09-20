import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            List<Integer> candidates = new ArrayList<>();
            
            // 4가지 반사 좌표
            int[][] mirrors = {
                {-targetX, targetY},        // 좌벽 반사
                {2 * m - targetX, targetY}, // 우벽 반사
                {targetX, -targetY},        // 아랫벽 반사
                {targetX, 2 * n - targetY}  // 윗벽 반사
            };
            
            for (int[] mirror : mirrors) {
                int mx = mirror[0];
                int my = mirror[1];
                
                int dx = startX - mx;
                int dy = startY - my;
                int dist = dx * dx + dy * dy;
                
                // 예외 케이스: 같은 x 또는 같은 y 선상에 있을 때
                if (startX == targetX) {
                    // 같은 세로선
                    if ((startY < targetY && targetY < my) || (my < targetY && targetY < startY)) {
                        continue;
                    }
                }
                if (startY == targetY) {
                    // 같은 가로선
                    if ((startX < targetX && targetX < mx) || (mx < targetX && targetX < startX)) {
                        continue;
                    }
                }
                
                candidates.add(dist);
            }
            
            answer[i] = Collections.min(candidates);
        }
        
        return answer;
    }
}