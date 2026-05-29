import java.util.ArrayList;
import java.util.List;

class Solution {

    // 시계방향(위, 오른, 아래, 왼)
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    int R;
    int C;

    boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        List<Integer> cycleList = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();

        // 위치 + 방향까지 보기 위해 3차원배열
        visited = new boolean[R][C][4];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[r][c][d]) {
                        cycleList.add(getCycleLength(r, c, d, grid));
                    }
                }
            }
        }

        return cycleList.stream().sorted().mapToInt(i -> i).toArray();
    }
    
    // 사이클 길이 구하기
    int getCycleLength(int r, int c, int d, String[] grid) {
        int cycleLength = 0;

        while (true) {
            if (visited[r][c][d]) {
                break;
            }

            visited[r][c][d] = true;
            cycleLength++;

            // 방향
            char D = grid[r].charAt(c);

            // 방향전환
            switch (D) {
                case 'L':
                    d = (d + 3) % 4;
                    break;
                case 'R':
                    d = (d + 1) % 4;
                    break;
            }

            // 격자를 벗어나면 반대편으로 이어지게
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }

        return cycleLength;
    }
}