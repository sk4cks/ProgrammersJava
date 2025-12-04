import java.util.*;

class Solution {
    public int solution(String[] board) {
        // 방향 벡터: 상, 하, 좌, 우
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        // 문자열 배열을 문자 배열로 변환
        char[][] arr = new char[board.length][board[0].length()];
        
        // 방문 배열: 몇 번째 이동인지 기록 (0 = 방문 안함)
        int[][] visited = new int[board.length][board[0].length()];
        
        // BFS 탐색을 위한 큐
        Queue<int[]> que = new LinkedList<>();
        
        // 도착 못할 경우 기본값 -1
        int answer = -1;
        
        // 시작점(R)을 찾고 큐에 넣기
        for(int i=0; i<board.length; i++) {
            arr[i] = board[i].toCharArray();
            if(board[i].indexOf("R") > -1) {
                que.add(new int[]{i,board[i].indexOf("R")});
                visited[i][board[i].indexOf("R")] = 1;  // 방문 기록 (1부터 시작)
            }
        }
        
        // BFS 시작
        while (!que.isEmpty()) {
            int[] cur = que.poll(); // 현재 위치

            // 목적지(G)에 도착하면 이동 횟수 반환
            if(arr[cur[0]][cur[1]] == 'G'){
                answer = visited[cur[0]][cur[1]] - 1;   // 1부터 시작했으니 -1
                break;
            }

            // 4방향으로 리코쳇(장애물 or 끝까지 미끄러짐)
            for(int i=0; i<dx.length; i++) {
                int nx = cur[0];
                int ny = cur[1];
                
                // 다음 칸이 범위 내이고 장애물(D)이 아닐 때까지 계속 이동
                while (0 <= nx + dx[i] && nx + dx[i] < arr.length 
                       && 0 <= ny + dy[i] && ny + dy[i] < arr[0].length 
                       && arr[nx + dx[i]][ny + dy[i]] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 도착한 칸이 방문되지 않은 경우 큐에 추가
                if (visited[nx][ny] == 0) {
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;  // 이동 횟수 증가
                }
            }
        }
        
        return answer;
    }
}