import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        char[][] arr = new char[board.length][board[0].length()];
        int[][] visited = new int[board.length][board[0].length()];
        Queue<int[]> que = new LinkedList<>();
        int answer = -1;
        
        for(int i=0; i<board.length; i++) {
            arr[i] = board[i].toCharArray();
            if(board[i].indexOf("R") > -1) {
                que.add(new int[]{i,board[i].indexOf("R")});
                visited[i][board[i].indexOf("R")] = 1;
            }
        }
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if(arr[cur[0]][cur[1]] == 'G'){
                answer = visited[cur[0]][cur[1]] - 1 ;
                break;
            }

            for(int i=0; i<dx.length; i++) {
                int nx = cur[0];
                int ny = cur[1];
                while (0 <= nx + dx[i] && nx + dx[i] < arr.length 
                       && 0 <= ny + dy[i] && ny + dy[i] < arr[0].length 
                       && arr[nx + dx[i]][ny + dy[i]] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                if (visited[nx][ny] == 0) {
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                }
            }
        }
        return answer;
    }
}