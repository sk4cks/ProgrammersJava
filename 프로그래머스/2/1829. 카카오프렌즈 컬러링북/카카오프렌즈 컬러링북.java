import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[picture.length][picture[0].length];
        Queue<int[]> que = new LinkedList<>();
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i=0; i<picture.length; i++) {
            for (int j=0; j<picture[i].length; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int areaCount = 1;
                    numberOfArea++;
                    visited[i][j] = true;
                    que.add(new int[]{i,j});

                    while (!que.isEmpty()) {
                        int[] cur = que.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int k=0; k<dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < picture.length && ny >= 0 && ny <picture[0].length) {
                                if (picture[i][j] == picture[nx][ny] && !visited[nx][ny]) {
                                    areaCount++;
                                    visited[nx][ny] = true;
                                    que.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaCount);
                }
            }
        }
        
        int[] answer = {numberOfArea, maxSizeOfOneArea};
        
        return answer;
    }
}