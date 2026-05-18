import java.util.*;

class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        /*
         grid[r][c]
         = 해당 칸에 물방울이 처음 떨어진 시간(index)

         초기값은 drops.length 로 설정
         → 끝까지 물이 떨어지지 않은 칸 의미
        */
        int[][] grid = new int[m][n];

        for (int[] row : grid) {
            Arrays.fill(row, drops.length);
        }

        /*
         물방울이 떨어진 최초 시간 기록
         
         예:
         drops[3] = {2,1}
         → (2,1)은 3초에 젖음
        */
        for (int i = 0; i < drops.length; i++) {

            int r = drops[i][0];
            int c = drops[i][1];

            // 가장 처음 떨어진 시간만 기록
            if (grid[r][c] == drops.length) {
                grid[r][c] = i;
            }
        }

        /*
         이분탐색

         "K초까지 안전한 h x w 영역 존재 여부"를 검사
        */
        int left = 0;
        int right = drops.length;

        int[] answer = {0, 0};

        while (left <= right) {

            int mid = (left + right) / 2;

            /*
             mid초까지 안전한 영역 탐색
             
             존재하면:
             → 더 늦은 시간도 가능한지 탐색
             
             없으면:
             → 시간을 줄여야 함
            */
            int[] pos = findSafeZone(m, n, h, w, grid, mid);

            if (pos != null) {
                answer = pos;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    /*
     K초까지 안전한 h x w 영역 탐색
     
     return:
     - 존재하면 시작 좌표 반환
     - 없으면 null
    */
    private int[] findSafeZone(int m, int n, int h, int w,
                               int[][] grid, int K) {

        /*
         누적합 배열
         
         pSum[i][j]
         = (0,0) ~ (i-1,j-1)까지 젖은 칸 개수
        */
        int[][] pSum = new int[m + 1][n + 1];

        // 누적합 생성
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                /*
                 K초 이전에 물이 떨어졌으면 젖은 칸
                */
                int val = (grid[i][j] < K) ? 1 : 0;

                pSum[i + 1][j + 1]
                        = val
                        + pSum[i][j + 1]
                        + pSum[i + 1][j]
                        - pSum[i][j];
            }
        }

        /*
         모든 h x w 영역 검사
        */
        for (int i = h; i <= m; i++) {
            for (int j = w; j <= n; j++) {

                /*
                 현재 사각형 내부 젖은 칸 개수 계산

                 좌상단:
                 (i-h, j-w)

                 우하단:
                 (i-1, j-1)
                */
                int sum =
                        pSum[i][j]
                      - pSum[i - h][j]
                      - pSum[i][j - w]
                      + pSum[i - h][j - w];

                /*
                 젖은 칸이 하나도 없으면
                 안전 영역 발견
                */
                if (sum == 0) {
                    return new int[]{i - h, j - w};
                }
            }
        }

        // 안전 영역 없음
        return null;
    }
}