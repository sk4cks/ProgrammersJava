import java.util.*;

class Solution {
    
    // places(대기실 5개)에 대해 거리두기 검사를 수행
    public int[] solution(String[][] places) {
        int[] answer = new int[5];  // 각 대기실의 결과 (1: 준수, 0: 불준수)

        Loop:
            for(int i=0; i<places.length; i++) {
                String[] place = places[i]; // 현재 대기실 (5 x 5)

                // 모든 좌표를 탐색하며 'P'(사람)를 찾는다
                for(int x=0; x<place.length; x++) {
                    for(int y=0; y<place[x].length(); y++) {
                        
                        // 사람(P)을 찾으면 BFS로 거리두기 위반 검사 시작
                        if(place[x].charAt(y) == 'P') {
                            
                            // 거리두기 위반이 있으면 바로 다음 대기실로 이동
                            if(!bfs(x,y,place)){
                                continue Loop;
                            }
                        }
                    }
                }
                
                // 위반 없이 모든 좌표 통과 → 거리두기 준수
                answer[i] = 1;
            }
        
        return answer;
    }
    
    // BFS를 이용해 사람(P) 주변 2칸 이내 거리두기 위반 여부 검사
    boolean bfs(int x, int y, String[] place) {
        
        // 상하좌우 이동 배열
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x,y});  // 시작점(P)

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i=0; i<dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                // 시작점으로부터의 맨해튼 거리 계산
                int d = Math.abs(nx-x) + Math.abs(ny-y);

                // 범위를 벗어나지 않고 / 자기 자신은 제외
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && ( nx != x || ny != y )) {
                    
                    // 1️⃣ 거리 2 이하에 'P'가 있으면 → 거리두기 위반
                    if (place[nx].charAt(ny) == 'P' && d <= 2) {
                        return false;
                        
                    // 2️⃣ 'O' (빈 테이블)이면서 거리가 아직 1이면 → BFS 계속 확장 가능
                    } else if (place[nx].charAt(ny) == 'O' && d < 2) {
                        que.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        // 문제 없음 → 준수
        return true;
    }
}