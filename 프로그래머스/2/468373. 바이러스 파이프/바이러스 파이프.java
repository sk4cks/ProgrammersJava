import java.util.*;

class Solution {
    private int n;
    private int k;
    private int answer = 0;
    private Map<Integer, List<int[]>> map;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int type = edge[2];

            map.get(u).add(new int[]{v, type});
            map.get(v).add(new int[]{u, type});
        }
        
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        
        dfs(0, infected);
        
        return answer;
    }
    
    private void dfs(int depth, boolean[] infected) {        
        answer = Math.max(answer, count(infected));
        
        if(depth == k) {
            return; 
        }
        
        for (int type = 1; type <= 3; type++) {
            boolean[] next = infected.clone();

            bfs(next, type);

            dfs(depth + 1, next);
        }
    }
    
    private void bfs(boolean[] infected, int type) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (infected[i]) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int[] edge : map.get(cur)) {
                int nextNode = edge[0];
                int edgeType = edge[1];

                if (edgeType != type) continue;

                if (infected[nextNode]) continue;

                infected[nextNode] = true;
                q.add(nextNode);
            }
        }
    }
    
    private int count(boolean[] infected) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) cnt++;
        }
        return cnt;
    }
}
