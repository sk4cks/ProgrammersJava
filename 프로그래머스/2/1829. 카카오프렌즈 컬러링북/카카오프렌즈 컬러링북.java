import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        // 방문 여부 체크 배열
        boolean[][] visited = new boolean[picture.length][picture[0].length];
        
        // BFS를 위한 큐
        Queue<int[]> que = new LinkedList<>();
        
        // 상하좌우 이동을 위한 방향 배열
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 전체 영역 개수
        int numberOfArea = 0;
        // 가장 큰 영역의 크기
        int maxSizeOfOneArea = 0;

        // 전체 그림을 순회
        for (int i=0; i<picture.length; i++) {
            for (int j=0; j<picture[i].length; j++) {
                
                // 색이 0이 아니고, 아직 방문하지 않은 경우 → 새로운 영역 시작
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int areaCount = 1; // 현재 영역 크기
                    
                    numberOfArea++;    // 영역 개수 증가
                    visited[i][j] = true;
                    
                    // BFS 시작점 큐에 추가
                    que.add(new int[]{i,j});

                    // BFS 탐색
                    while (!que.isEmpty()) {
                        int[] cur = que.poll();
                        int x = cur[0];
                        int y = cur[1];

                        // 4방향 탐색
                        for (int k=0; k<dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            // 배열 범위 체크
                            if (nx >= 0 && nx < picture.length && ny >= 0 && ny < picture[0].length) {
                                
                                /*
                                 같은 색이고 아직 방문하지 않았다면
                                 → 같은 영역으로 판단
                                */
                                if (picture[i][j] == picture[nx][ny] && !visited[nx][ny]) {
                                    areaCount++;              // 영역 크기 증가
                                    visited[nx][ny] = true;   // 방문 처리
                                    que.add(new int[]{nx, ny}); // 큐에 추가
                                }
                            }
                        }
                    }

                    // 현재까지의 최대 영역 크기 갱신
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaCount);
                }
            }
        }
        
        // 결과: [영역 개수, 최대 영역 크기]
        int[] answer = {numberOfArea, maxSizeOfOneArea};
        
        return answer;
    }
}