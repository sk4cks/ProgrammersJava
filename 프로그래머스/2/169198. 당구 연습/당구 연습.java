import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i=0; i<balls.length; i++) {
            List<Integer> distList = new ArrayList<>();
            int[] target = balls[i];
            int[][] mirros = {
                {target[0], 2*n - target[1]}, // 윗벽 반사
                {2*m - target[0], target[1]}, // 오른벽 반사
                {target[0], -target[1]}, // 아랫벽 반사
                {-target[0], target[1]} // 왼벽 반사
            };

            // 목표 공을 좌우/상하 대칭 복제해두고, 내 공에서 목표 공 복제본까지 직선거리 구하기
            for (int[] mirror : mirros) {
                int dx = mirror[0] - startX;
                int dy = mirror[1] - startY;
                int dist = dx*dx + dy*dy;

                // 같은 X선상 예외처리
                if (startX == target[0]) {
                    if ( (startY < target[1] && target[1] < mirror[1]) 
                        || (mirror[1] < target[1] && target[1] < startY)) {
                        continue;
                    }
                }

                // 같은 Y선상 예외처리
                if (startY == target[1]) {
                    if ( (startX < target[0] && target[0] < mirror[0]) 
                        || (mirror[0] < target[0] && target[0] < startX)) {
                        continue;
                    }
                }

                distList.add(dist);
            }

            answer[i] = Collections.min(distList);
        }
        
        return answer;
    }
}