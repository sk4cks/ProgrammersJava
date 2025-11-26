import java.util.*;

class Solution {
    
    // 상하좌우 이동을 위한 방향 배열 (동, 남, 서, 북)
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    
    public int solution(String[] maps) {
        
        // 문자열 맵을 문자 배열로 변환
        char[][] charMaps = new char[maps.length][maps[0].length()];
        int[] start = new int[2];   // 시작점 좌표
        int[] lever = new int[2];   // 레버 좌표

        // 맵을 순회하면서 시작점 'S'와 레버 'L' 위치 저장
        for(int i=0; i<maps.length; i++) {
            charMaps[i] = maps[i].toCharArray();
            for(int j=0; j<charMaps[i].length; j++) {
                switch(charMaps[i][j]) {
                    case 'S':
                        start = new int[]{i, j};
                        break;
                    case 'L':
                        lever = new int[]{i, j};
                        break;
                }
            }
        }
        int leverCount = bfs(charMaps,start,'L');   // BFS로 시작점 -> 레버까지 최단거리 탐색
        int exitCount = bfs(charMaps,lever,'E');    // BFS로 레버 -> 출구까지 최단거리 탐색
        
        // 레버 또는 출구에 도달할 수 없으면 -1 반환
        // 가능하면 두 구간 합산하여 반환
        return (leverCount == -1 || exitCount == -1) ? -1 : leverCount + exitCount;
    }
    
    // BFS로 목표 지점(goal)까지 최단거리 탐색
    int bfs(char[][] charMaps, int[] start, char goal) {
        Queue<int[]> que = new LinkedList<>();
        
        // 방문 여부를 기록하는 배열
        boolean[][] visited = new boolean[charMaps.length][charMaps[0].length];
        
        // 큐에 시작점과 이동 거리(0) 저장
        que.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            
            // 현재 위치가 목표 지점이면 이동 거리 반환
            if(charMaps[arr[0]][arr[1]] == goal) return arr[2];

            // 상하좌우 탐색
            for(int i=0; i< dx.length; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                // 맵 범위 내에 있고, 벽이 아니며, 방문하지 않은 곳이면 큐에 추가
                if( 0 <= nx && nx < charMaps.length && 0 <= ny && ny < charMaps[0].length){
                    if(charMaps[nx][ny] != 'X' && !visited[nx][ny]) {
                        que.add(new int[]{nx,ny,arr[2]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우 -1 반환
        return -1;
    }
}