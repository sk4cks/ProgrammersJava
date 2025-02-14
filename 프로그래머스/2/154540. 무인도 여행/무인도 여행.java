import java.util.*;

class Solution {
    int[] nx = {-1, 0, 1, 0};
    int[] ny = {0, -1, 0, 1};
    char[][] map;
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    list.add(bfs(i,j));
                }
            }
        }

        if(list.size()==0) list.add(-1);
        
        return list.stream().sorted().mapToInt(i->i).toArray();
    }
    
    int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();

        int count = Character.getNumericValue(map[x][y]);
        visited[x][y] = true;
        que.add(new int[]{x,y});

        while (!que.isEmpty()) {
            int[] arr = que.poll();

            for(int i=0; i<nx.length; i++) {
                int dx = arr[0] + nx[i];
                int dy = arr[1] + ny[i];

                if(dx >= 0 && dx < map.length && dy >= 0 && dy < map[0].length) {
                    if(map[dx][dy] != 'X' && !visited[dx][dy]) {
                        count += Character.getNumericValue(map[dx][dy]);
                        visited[dx][dy] = true;
                        que.add(new int[]{dx,dy});
                    }
                }
            }
        }

        return count;
    }
}