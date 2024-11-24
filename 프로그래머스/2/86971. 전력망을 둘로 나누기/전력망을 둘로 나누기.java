import java.util.*;

class Solution {
    
    Map<Integer,List<Integer>> map = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        //{1: []}, {2: []}, {3: []}, {4: []} 데이터 만들기
        for(int i=1; i<=n; i++) {
            map.put(i,new ArrayList<>());
        }

        //{1: [3]}, {2: [3]}, {3: [4]}, {4: [5,6,7]} 데이터 만들기
        for(int i=0; i<wires.length; i++) {
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }

        //하나씩 자르면서 최소값 구하기
        for(int i=0; i<wires.length; i++) {
            boolean[] visited = new boolean[n+1];

            //자르고
            map.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            map.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));

            int count = dfs(wires[i][0],visited);
            answer = Math.min(answer, Math.abs(count - (n-count)));
            
            if(answer == 0) break;

            //다시 추가
            map.get(wires[i][0]).add(Integer.valueOf(wires[i][1]));
            map.get(wires[i][1]).add(Integer.valueOf(wires[i][0]));
        }
        
        return answer;
    }
    
    int dfs (int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;

        for(int next : map.get(v)) {
            if(!visited[next]) {
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }
    
}