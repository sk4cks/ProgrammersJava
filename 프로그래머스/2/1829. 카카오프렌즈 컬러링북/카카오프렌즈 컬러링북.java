import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        // 방향 벡터 (상하좌우)
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 방문했거나 색이 0이면 스킵
                if (visited[i][j] || picture[i][j] == 0) continue;

                numberOfArea++;

                int color = picture[i][j]; // 기준 색 저장
                int areaSize = 1;

                // BFS 시작
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];

                        // 범위 체크 + 방문 여부 + 같은 색
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (visited[nx][ny] || picture[nx][ny] != color) continue;

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        areaSize++;
                    }
                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}