import java.util.ArrayList;

class Solution {

    /*
     * 격자 크기
     */
    static int R, C;

    /*
     * 방향 벡터
     *
     * d 기준:
     * 0 : 위
     * 1 : 왼쪽
     * 2 : 아래
     * 3 : 오른쪽
     */
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    /*
     * isVisited[r][c][d]
     *
     * (r,c) 위치에 d 방향으로 들어온 적이 있는지
     *
     * 같은 위치라도 방향이 다르면
     * 서로 다른 경로로 취급
     */
    static boolean[][][] isVisited;

    public int[] solution(String[] grid) {

        ArrayList<Integer> answer = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();

        /*
         * 모든 위치 + 방향에 대해 탐색
         */
        isVisited = new boolean[R][C][4];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {

                    /*
                     * 아직 방문하지 않은 경로라면
                     * 하나의 사이클 탐색 시작
                     */
                    if (!isVisited[r][c][d]) {
                        answer.add(light(grid, r, c, d));
                    }
                }
            }
        }

        /*
         * 사이클 길이를 오름차순 정렬 후 반환
         */
        return answer.stream()
                     .sorted()
                     .mapToInt(i -> i)
                     .toArray();
    }

    /*
     * 하나의 빛 경로(사이클) 탐색
     *
     * return:
     * - 사이클 길이
     */
    private static int light(String[] grid, int r, int c, int d) {

        /*
         * 현재 사이클 이동 거리
         */
        int cnt = 0;

        while (true) {

            /*
             * 같은 위치 + 방향을 다시 방문하면
             * 사이클 완성
             */
            if (isVisited[r][c][d]) {
                break;
            }

            cnt++;

            // 현재 상태 방문 처리
            isVisited[r][c][d] = true;

            /*
             * 현재 칸의 문자에 따라 방향 전환
             *
             * S : 직진
             * L : 좌회전
             * R : 우회전
             */
            char command = grid[r].charAt(c);

            // 좌회전
            if (command == 'L') {
                d = (d == 0) ? 3 : d - 1;
            }

            // 우회전
            else if (command == 'R') {
                d = (d == 3) ? 0 : d + 1;
            }

            /*
             * 다음 위치 이동
             *
             * 격자를 벗어나면
             * 반대편으로 이어짐
             */
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }

        return cnt;
    }
}