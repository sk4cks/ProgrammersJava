import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        Loop:
            for(int i=0; i<places.length; i++) {
                String[] place = places[i];

                for(int x=0; x<place.length; x++) {
                    for(int y=0; y<place[x].length(); y++) {
                        if(place[x].charAt(y) == 'P') {
                            if(!bfs(x,y,place)){
                                continue Loop;
                            }
                        }
                    }
                }
                answer[i] = 1;
            }
        
        return answer;
    }
    
    boolean bfs(int x, int y, String[] place) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x,y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for(int i=0; i<dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int d = Math.abs(nx-x) + Math.abs(ny-y);

                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && ( nx != x || ny != y )) {
                    if(place[nx].charAt(ny) == 'P' && d <= 2) {
                        return false;
                    }else if(place[nx].charAt(ny) == 'O' && d < 2) {
                        que.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        return true;
    }
}