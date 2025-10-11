import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;        // 행의 개수
        int m = land[0].length;     // 열의 개수
        
        // 상하좌우 이동을 위한 방향 벡터
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        boolean[][] visited = new boolean[n][m];    // 방문 여부 체크용
        int[] colSum = new int[m];                  // 각 열(시추 위치)에 대해 얻을 수 있는 석유량 합계 저장용
        
        // 모든 칸을 순회하면서, 아직 방문하지 않은 석유 덩어리를 BFS로 탐색
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                
                // 아직 방문하지 않은 석유(1)를 찾았을 경우
                if (land[i][j] == 1 && !visited[i][j]) {
                    
                    Set<Integer> colSet = new HashSet<>();  // 현재 석유 덩어리가 포함된 열 번호 저장 (중복 방지)
                    Queue<int[]> que = new LinkedList<>();  // BFS 탐색용 큐
                    que.add(new int[]{i,j});
                    visited[i][j] = true;                   // 시작점 방문 처리
                    int oilCnt = 0;                         // 현재 석유 덩어리의 총 크기(셀 수)

                    // BFS 시작
                    while (!que.isEmpty()) {
                        int[] now = que.poll();
                        int x = now[0];
                        int y = now[1];

                        oilCnt++;           // 석유 칸 하나 더 카운트
                        colSet.add(y);      // 해당 칸의 열 정보 저장

                        // 상하좌우 탐색
                        for (int k=0; k<dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            // 지도 범위 내에 있고, 석유가 있으며, 아직 방문하지 않았다면
                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                                    que.add(new int[]{nx,ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }

                    // 하나의 석유 덩어리에 대해, 포함된 모든 열에 석유량 추가
                    // (해당 열에 시추하면 이 덩어리 전체를 얻을 수 있음)
                    for (int col : colSet) {
                        colSum[col] += oilCnt;
                    }
                }
            }
        }
        
        // 가장 많은 석유를 얻을 수 있는 열(시추 위치)을 선택
        answer = Arrays.stream(colSum).max().orElse(0);
        
        return answer;
    }
}