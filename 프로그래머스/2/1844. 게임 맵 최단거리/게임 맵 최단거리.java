import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 방문 및 거리 기록용 배열 (maps와 동일한 크기)
        int[][] stateMap = new int[maps.length][maps[0].length];
        
        // BFS 실행
        bfs(maps,stateMap);
        
        // 도착 지점까지의 거리 확인
        answer = stateMap[maps.length-1][maps[0].length-1];
        
        // 도착 지점에 도달하지 못한 경우 -1 반환
        if(answer==0) answer= -1;
        
        return answer;
    }
    
    void bfs(int[][] maps, int[][] stateMap){
        Queue<int[]> que = new LinkedList<>();
        
        // 상하좌우 이동을 위한 좌표 변화 배열
        int[] nX = {1,-1,0,0};
        int[] nY = {0,0,1,-1};
        
        stateMap[0][0] +=1; // 시작점 방문 표시 (거리 = 1)
        que.add(new int[]{0, 0}); // 시작점 큐에 넣기

        while (!que.isEmpty()){
            int[] cur = que.poll(); // 현재 위치 꺼내기
            
            // 상하좌우 탐색
            for(int i=0; i<4; i++){
                int nextX = cur[0]+nX[i];
                int nextY = cur[1]+nY[i];

                // 1. 맵 밖으로 나가는 경우
                // 2. 벽인 경우 (maps[nextX][nextY] == 0)
                // 3. 이미 방문한 경우 (stateMap[nextX][nextY] != 0)
                if(nextX < 0 || nextY < 0
                        || nextX > maps.length-1 || nextY > maps[0].length-1
                        || maps[nextX][nextY] == 0 || stateMap[nextX][nextY] != 0)
                    continue;

                // 다음 위치 큐에 추가
                que.add(new int[]{nextX, nextY});
                // 현재 위치까지의 거리 + 1 기록
                stateMap[nextX][nextY] = stateMap[cur[0]][cur[1]]+1;
            }
        }
    }
}