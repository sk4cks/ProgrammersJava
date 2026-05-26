import java.util.*;

class Solution {

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

        int[] answer = new int[balls.length];

        // 각 목표 공에 대해 최소 거리 계산
        for (int i = 0; i < balls.length; i++) {

            int targetX = balls[i][0];
            int targetY = balls[i][1];

            // 최소 거리 제곱값
            int minDist = Integer.MAX_VALUE;

            /*
             반사 좌표 생성
             
             목표 공을 벽 기준으로 반사시켜
             시작점 → 반사 좌표까지의 직선 거리로 계산한다.
            */
            int[][] mirrors = {
                { targetX, 2 * n - targetY }, // 위쪽 벽 반사
                { 2 * m - targetX, targetY }, // 오른쪽 벽 반사
                { targetX, -targetY },        // 아래쪽 벽 반사
                { -targetX, targetY }         // 왼쪽 벽 반사
            };

            for (int[] mirror : mirrors) {

                int mirrorX = mirror[0];
                int mirrorY = mirror[1];

                /*
                 시작점과 목표 공이 같은 x축 상에 있는 경우

                 시작점 → 목표 공 → 반사 좌표 순서가 되면
                 벽에 맞기 전에 공을 먼저 맞게 되므로 제외
                */
                if (startX == targetX) {

                    // 위쪽 방향
                    if (startY < targetY && targetY < mirrorY) {
                        continue;
                    }

                    // 아래쪽 방향
                    if (mirrorY < targetY && targetY < startY) {
                        continue;
                    }
                }

                /*
                 시작점과 목표 공이 같은 y축 상에 있는 경우

                 중간에 목표 공을 먼저 맞는 경로 제외
                */
                if (startY == targetY) {

                    // 오른쪽 방향
                    if (startX < targetX && targetX < mirrorX) {
                        continue;
                    }

                    // 왼쪽 방향
                    if (mirrorX < targetX && targetX < startX) {
                        continue;
                    }
                }

                // 거리 제곱 계산
                int dx = mirrorX - startX;
                int dy = mirrorY - startY;

                int dist = dx * dx + dy * dy;

                minDist = Math.min(minDist, dist);
            }

            answer[i] = minDist;
        }

        return answer;
    }
}