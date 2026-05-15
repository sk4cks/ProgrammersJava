import java.util.*;

class Solution {

    private int n;  // 전체 노드 개수
    private int k;  // 최대 선택 가능한 감염 타입 횟수

    private int answer = 0; // 감염 가능한 최대 노드 수

    /*
     그래프 저장

     key   : 현재 노드
     value : [다음 노드, 간선 타입]
    */
    private Map<Integer, List<int[]>> map;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.n = n;
        this.k = k;

        // 그래프 초기화
        map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        /*
         양방향 그래프 생성

         edge = [u, v, type]
         → u ↔ v 연결
        */
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int type = edge[2];

            map.get(u).add(new int[]{v, type});
            map.get(v).add(new int[]{u, type});
        }

        // 초기 감염 상태
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        // DFS 시작
        dfs(0, infected);

        return answer;
    }

    /*
     DFS
     
     depth : 현재까지 사용한 감염 타입 횟수
     
     핵심:
     매 단계마다
     "1번 타입 / 2번 타입 / 3번 타입"
     중 하나를 선택해서 감염 확산
    */
    private void dfs(int depth, boolean[] infected) {

        // 현재 감염 수 최대값 갱신
        answer = Math.max(answer, count(infected));

        // k번 선택 완료 시 종료
        if(depth == k) {
            return;
        }

        /*
         다음 감염 타입 선택
         
         type = 1, 2, 3
        */
        for (int type = 1; type <= 3; type++) {

            /*
             현재 상태 복사
             
             DFS 분기마다 독립적인 감염 상태 유지 필요
            */
            boolean[] next = infected.clone();

            // 선택한 타입으로 감염 확산
            bfs(next, type);

            // 다음 단계 진행
            dfs(depth + 1, next);
        }
    }

    /*
     BFS
     
     선택한 타입(type)의 간선만 따라가며 감염 확산
    */
    private void bfs(boolean[] infected, int type) {

        Queue<Integer> q = new LinkedList<>();

        /*
         현재 감염된 모든 노드를 시작점으로 큐에 삽입
        */
        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                q.add(i);
            }
        }

        // BFS 시작
        while (!q.isEmpty()) {

            int cur = q.poll();

            // 현재 노드와 연결된 간선 탐색
            for (int[] edge : map.get(cur)) {

                int nextNode = edge[0];
                int edgeType = edge[1];

                // 현재 선택한 타입의 간선만 사용 가능
                if (edgeType != type) continue;

                // 이미 감염된 노드는 스킵
                if (infected[nextNode]) continue;

                // 감염 처리
                infected[nextNode] = true;

                // 다음 탐색 큐에 추가
                q.add(nextNode);
            }
        }
    }

    /*
     현재 감염된 노드 수 계산
    */
    private int count(boolean[] infected) {

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}