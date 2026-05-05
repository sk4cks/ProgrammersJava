import java.util.*;

class Solution {

    // 상하좌우 이동
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    char[][] map;
    boolean[][] visited;

    public int[] solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        map = new char[n][m];
        visited = new boolean[n][m];

        List<Integer> result = new ArrayList<>();

        // 문자열 → char 배열 변환
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        // 전체 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 바다(X)거나 이미 방문 → 스킵
                if (map[i][j] == 'X' || visited[i][j]) continue;

                // BFS로 해당 영역 식량 합 계산
                result.add(bfs(i, j));
            }
        }

        // 결과 없으면 -1
        if (result.isEmpty()) return new int[]{-1};

        // 정렬
        Collections.sort(result);

        // 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }

    // BFS: 연결된 지역 식량 합 계산
    int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();

        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        int sum = map[x][y] - '0'; // char → int 변환

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                // 범위 밖
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;

                // 바다 or 방문
                if (map[nx][ny] == 'X' || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                sum += map[nx][ny] - '0';
            }
        }

        return sum;
    }
}