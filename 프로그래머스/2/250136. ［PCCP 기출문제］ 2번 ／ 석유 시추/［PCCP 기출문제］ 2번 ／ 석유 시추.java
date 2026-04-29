import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] colSum = new int[m]; // 각 열별 획득 가능한 석유량

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 석유 아니거나 이미 방문 → 스킵
                if (land[i][j] == 0 || visited[i][j]) continue;

                // 현재 덩어리가 포함된 열 체크 (Set → boolean[])
                boolean[] usedCol = new boolean[m];

                int oilSize = 0;

                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i, j});
                visited[i][j] = true;

                // BFS
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    oilSize++;
                    usedCol[y] = true;

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        // 범위 밖 or 방문 or 석유 아님
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visited[nx][ny] || land[nx][ny] == 0) continue;

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }

                // 해당 덩어리가 포함된 열에 석유량 누적
                for (int col = 0; col < m; col++) {
                    if (usedCol[col]) {
                        colSum[col] += oilSize;
                    }
                }
            }
        }

        // 최대값 반환
        int answer = 0;
        for (int val : colSum) {
            answer = Math.max(answer, val);
        }

        return answer;
    }
}