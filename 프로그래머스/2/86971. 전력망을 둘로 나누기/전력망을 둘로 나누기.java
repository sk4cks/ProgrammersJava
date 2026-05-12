import java.util.*;

class Solution {
    
    // 송전탑 연결 정보를 저장할 그래프
    // key: 현재 송전탑 번호
    // value: 연결된 송전탑 목록
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        
        // 두 전력망의 송전탑 개수 차이 최소값
        int answer = Integer.MAX_VALUE;

        /*
         그래프 초기화
         
         예:
         {
           1: [],
           2: [],
           3: [],
           ...
         }
        */
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        /*
         양방향 그래프 생성
         
         예:
         wires = [[1,3], [2,3]]
         
         결과:
         1 -> [3]
         2 -> [3]
         3 -> [1,2]
        */
        for(int i = 0; i < wires.length; i++) {
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }

        /*
         모든 전선을 하나씩 끊어보면서 검사
        */
        for(int i = 0; i < wires.length; i++) {

            boolean[] visited = new boolean[n + 1];

            int a = wires[i][0];
            int b = wires[i][1];

            /*
             전선 제거
             a <-> b 연결 끊기
            */
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(a));

            /*
             한쪽 전력망 크기 계산
             
             DFS 결과:
             count = 연결된 송전탑 개수
            */
            int count = dfs(a, visited);

            /*
             두 전력망 크기 차이 계산
             
             count
             vs
             n - count
            */
            answer = Math.min(answer, Math.abs(count - (n - count)));

            // 차이가 0이면 최적값이므로 종료 가능
            if(answer == 0) break;

            /*
             다음 테스트를 위해 다시 연결 복구
            */
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        return answer;
    }
    
    /*
     DFS로 연결된 송전탑 개수 계산
     
     반환값:
     현재 노드를 포함한 연결된 전체 노드 수
    */
    int dfs(int v, boolean[] visited) {

        visited[v] = true;

        // 현재 노드 포함
        int cnt = 1;

        // 연결된 다음 노드 탐색
        for(int next : map.get(v)) {

            // 아직 방문하지 않았다면 DFS 진행
            if(!visited[next]) {
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }
}