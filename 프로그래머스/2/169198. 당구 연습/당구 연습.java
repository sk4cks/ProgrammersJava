import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int tx = balls[i][0];
            int ty = balls[i][1];

            int[][] mirrors = {
                { tx, 2 * n - ty }, // 위쪽 벽
                { 2 * m - tx, ty }, // 오른쪽 벽
                { tx, -ty },        // 아래쪽 벽
                { -tx, ty }         // 왼쪽 벽
            };

            int minDist = Integer.MAX_VALUE;

            for (int[] mirror : mirrors) {
                int mx = mirror[0];
                int my = mirror[1];

                // 같은 축 위에서 벽보다 목표 공이 먼저 걸리는 경로 제외
                if (startX == tx && isBetween(ty, startY, my)) continue;
                if (startY == ty && isBetween(tx, startX, mx)) continue;

                int dx = mx - startX;
                int dy = my - startY;
                minDist = Math.min(minDist, dx * dx + dy * dy);
            }

            answer[i] = minDist;
        }

        return answer;
    }

    // value가 a와 b 사이에 있는지 확인 (양 끝 제외)
    private boolean isBetween(int value, int a, int b) {
        return Math.min(a, b) < value && value < Math.max(a, b);
    }
}