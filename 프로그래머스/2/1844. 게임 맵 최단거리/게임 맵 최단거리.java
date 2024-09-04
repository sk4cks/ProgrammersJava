import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] stateMap = new int[maps.length][maps[0].length];
        bfs(maps,stateMap);
        
        answer = stateMap[maps.length-1][maps[0].length-1];
        if(answer==0) answer= -1;
        
        return answer;
    }
    
    void bfs(int[][] maps, int[][] stateMap){
        Queue<int[]> que = new LinkedList<>();
        int[] nX = {1,-1,0,0};
        int[] nY = {0,0,1,-1};
        stateMap[0][0] +=1;
        que.add(new int[]{0, 0});

        while (!que.isEmpty()){
            int[] cur = que.poll();
            for(int i=0; i<4; i++){
                int nextX = cur[0]+nX[i];
                int nextY = cur[1]+nY[i];

                if(nextX < 0 || nextY < 0
                        || nextX > maps.length-1 || nextY > maps[0].length-1
                        || maps[nextX][nextY] == 0 || stateMap[nextX][nextY] != 0)
                    continue;

                que.add(new int[]{nextX, nextY});
                stateMap[nextX][nextY] = stateMap[cur[0]][cur[1]]+1;
            }
        }
    }
}