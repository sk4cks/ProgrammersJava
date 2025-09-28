import java.util.*;

class Solution {
    
    int answer = 0; // 정답 개수를 세는 전역 변수
    
    public int solution(int n, int[][] q, int[] ans) {
        
        // DFS를 이용해 1~n까지 숫자 중 5개를 고르는 모든 조합 탐색 시작
        dfs(n, q, ans, 1, new ArrayList<>());
        
        return answer;
    }
    
    // DFS: 조합 생성 (n: 숫자 개수, q: 질문 배열, ans: 정답 배열, start: 시작 숫자, list: 현재 선택한 숫자들)
    void dfs(int n, int[][] q, int[] ans, int start, List<Integer> list) {
        
        if(list.size() == 5) {  // 5개를 뽑았을 경우
            
            // 현재 조합(list)이 조건을 만족하는지 검증
            if(checkValidation(q, ans, list)) answer++;
            return;
        }

        // start부터 n까지 순차적으로 숫자를 하나씩 선택
        for (int i=start; i<=n; i++) {
            list.add(i);                // 숫자 선택
            dfs(n, q, ans, i+1, list);  // 다음 숫자는 i+1부터 시작 (중복 방지)
            list.remove(list.size()-1); // 백트래킹 (선택한 숫자 취소)
        }
    }
    
    // 현재 조합(list)이 주어진 조건(q, ans)을 만족하는지 검사
    boolean checkValidation(int[][] q, int[] ans, List<Integer> list) {
        for (int i=0; i<q.length; i++) {            // 각 질문에 대해
            int cnt = 0;
            for (int j=0; j<q[i].length; j++) {     // 질문에 포함된 숫자들 확인
                for (int k=0; k<list.size(); k++) { // 현재 뽑은 조합과 비교
                    if (list.get(k) == q[i][j]) {   // 조합에 포함되면 카운트 증가
                        cnt++;
                        break;                      // 같은 숫자는 한 번만 세면 됨
                    }
                }
            }

            // 해당 질문의 정답 개수(ans[i])와 맞지 않으면 실패
            if(cnt != ans[i]) return false;
        }

        // 모든 질문의 조건을 만족하면 true
        return true;
    }
    
}