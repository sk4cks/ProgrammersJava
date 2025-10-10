import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;      // 행 수
        int m = land[0].length;   // 열 수
        
        int[][] visited = new int[n][m];  // 방문 여부 + 덩어리 구분용 ID
        int[] colSum = new int[m];        // 열(column)별 석유량 합
        int id = 1;                       // 덩어리 식별 번호

        // 상, 하, 좌, 우 방향 정의
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // land 전체 순회
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                // 아직 방문 안한 석유 발견 → BFS 시작
                if (land[i][j] == 1 && visited[i][j] == 0) {

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = id;

                    int oilCount = 0;           // 덩어리 내 석유량 카운트
                    Set<Integer> colSet = new HashSet<>(); // 포함된 열 기록

                    // BFS 시작
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];

                        oilCount++;         // 석유량 +1
                        colSet.add(y);      // 이 덩어리가 포함된 열 추가

                        // 상하좌우 탐색
                        for (int d=0; d<4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            // 경계 벗어나면 무시
                            if (nx<0 || ny<0 || nx>=n || ny>=m) continue;

                            // 아직 방문 안한 석유면 큐에 추가
                            if (land[nx][ny] == 1 && visited[nx][ny] == 0) {
                                visited[nx][ny] = id;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }

                    // BFS 끝 → 이 덩어리가 걸친 모든 열에 석유량 더하기
                    for (int col : colSet) {
                        colSum[col] += oilCount;
                    }

                    id++; // 다음 덩어리 ID 증가
                }
            }
        }

        // 열(column) 중 가장 많은 석유를 얻을 수 있는 값 찾기
        int max = 0;
        
        for (int c=0; c<m; c++) {
            max = Math.max(max, colSum[c]);
        }
        
        return max;
    }
}