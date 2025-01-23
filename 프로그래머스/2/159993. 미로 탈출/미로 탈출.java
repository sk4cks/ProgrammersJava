import java.util.*;

class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    
    public int solution(String[] maps) {
        char[][] charMaps = new char[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];

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
        int leverCount = bfs(charMaps,start,'L');
        int exitCount = bfs(charMaps,lever,'E');
        
        return (leverCount == -1 || exitCount == -1) ? -1 : leverCount + exitCount;
    }
    
    int bfs(char[][] charMaps, int[] start, char goal) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[charMaps.length][charMaps[0].length];
        que.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            
            if(charMaps[arr[0]][arr[1]] == goal) return arr[2];

            for(int i=0; i< dx.length; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                if( 0 <= nx && nx < charMaps.length && 0 <= ny && ny < charMaps[0].length){
                    if(charMaps[nx][ny] != 'X' && !visited[nx][ny]) {
                        que.add(new int[]{nx,ny,arr[2]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}