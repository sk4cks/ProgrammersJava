import java.util.*;

class Solution {
    
    // 상하좌우 이동을 위한 방향 배열
    int[] nx = {-1, 0, 1, 0};
    int[] ny = {0, -1, 0, 1};
    
    char[][] map;           // 문자로 변환된 지도 저장
    boolean[][] visited;    // 방문 여부 체크 배열
    
    public int[] solution(String[] maps) {
        
        // 지도와 방문 배열 초기화
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        // 문자열 배열을 문자 배열로 변환
        for(int i=0; i<maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        // 모든 칸을 순회하며 탐색
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                
                // 'X'가 아닌 땅이면서 방문하지 않은 경우 BFS 실행
                if(map[i][j] != 'X' && !visited[i][j]) {
                    list.add(bfs(i,j)); // 해당 지역의 총 식량 합을 list에 추가
                }
            }
        }

        // 탐색된 지역이 하나도 없으면 -1 추가
        if(list.size()==0) list.add(-1);
        
        // 리스트를 오름차순 정렬 후 배열로 변환하여 반환
        return list.stream().sorted().mapToInt(i->i).toArray();
    }
    
    // BFS를 통해 연결된 지역의 총 식량 값을 계산하는 함수
    int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();

        // 현재 위치의 식량 값으로 초기화
        int count = Character.getNumericValue(map[x][y]);
        visited[x][y] = true;
        que.add(new int[]{x,y});

        while (!que.isEmpty()) {
            int[] arr = que.poll(); // 큐에서 현재 좌표 가져오기

            // 상하좌우 탐색
            for(int i=0; i<nx.length; i++) {
                int dx = arr[0] + nx[i];
                int dy = arr[1] + ny[i];

                // 지도 범위를 벗어나지 않는지 체크
                if(dx >= 0 && dx < map.length && dy >= 0 && dy < map[0].length) {
                    
                    // 'X'가 아니고 방문하지 않은 땅이라면
                    if(map[dx][dy] != 'X' && !visited[dx][dy]) {
                        
                        // 해당 위치의 식량 값을 합산
                        count += Character.getNumericValue(map[dx][dy]);
                        visited[dx][dy] = true;     // 방문 체크
                        que.add(new int[]{dx,dy});  // 다음 탐색 큐에 추가
                    }
                }
            }
        }

        return count;   // 연결된 지역의 총 식량 값 반환
    }
}