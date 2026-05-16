import java.util.*;

class Solution {

    // 간선 정보
    static class Edge {
        int to;
        int type;

        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    List<Edge>[] graph;
    int n;
    int maxInfected = 0;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.n = n;

        // 그래프 초기화
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 그래프 생성
        for (int[] edge : edges) {

            int from = edge[0];
            int to = edge[1];
            int type = edge[2];

            graph[from].add(new Edge(to, type));
            graph[to].add(new Edge(from, type));
        }

        // 초기 감염 상태
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        // 감염 타입 선택 시작
        dfs(0, k, infected);

        return maxInfected;
    }

    /*
     DFS
     - 매 단계마다 감염 타입(1~3) 선택
     - 선택한 타입으로 감염 확산
    */
    void dfs(int depth, int k, boolean[] infected) {

        // 현재 감염 수 갱신
        maxInfected = Math.max(maxInfected, countInfected(infected));

        // k번 모두 선택 완료
        if (depth == k) {
            return;
        }

        // 타입 1 ~ 3 선택
        for (int type = 1; type <= 3; type++) {

            // 현재 상태 복사
            boolean[] next = infected.clone();

            // 해당 타입으로 감염 확산
            spread(type, next);

            // 다음 타입 선택
            dfs(depth + 1, k, next);
        }
    }

    /*
     선택한 타입의 간선만 따라 감염 확산
    */
    void spread(int type, boolean[] infected) {

        Queue<Integer> queue = new ArrayDeque<>();

        // 현재 감염된 노드들을 시작점으로 추가
        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                queue.offer(i);
            }
        }

        // BFS
        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (Edge edge : graph[cur]) {

                // 선택한 타입의 간선만 이동 가능
                if (edge.type != type) continue;

                // 이미 감염된 노드 제외
                if (infected[edge.to]) continue;

                infected[edge.to] = true;
                queue.offer(edge.to);
            }
        }
    }

    // 현재 감염된 노드 개수 계산
    int countInfected(boolean[] infected) {

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                count++;
            }
        }

        return count;
    }
}