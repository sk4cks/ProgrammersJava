import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        boolean[][] visited = new boolean[n][m];
        int[] colSum = new int[m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    
                    Set<Integer> colSet = new HashSet<>();
                    Queue<int[]> que = new LinkedList<>();
                    que.add(new int[]{i,j});
                    visited[i][j] = true;
                    int oilCnt = 0;

                    while (!que.isEmpty()) {
                        int[] now = que.poll();
                        int x = now[0];
                        int y = now[1];

                        oilCnt++;
                        colSet.add(y);

                        for (int k=0; k<dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                                    que.add(new int[]{nx,ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }

                    for (int col : colSet) {
                        colSum[col] += oilCnt;
                    }
                }
            }
        }
        
        answer = Arrays.stream(colSum).max().orElse(0);
        
        return answer;
    }
}