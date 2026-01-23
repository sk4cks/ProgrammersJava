class Solution {
    
    // 8명의 친구들 (고정 순서)
    char[] friends = {'A','C','F','J','M','N','R','T'};
    
    // 해당 친구를 이미 배치했는지 체크하는 배열
    boolean[] visited = new boolean[8];
    
    // 조건을 만족하는 전체 경우의 수
    int answer = 0;
    
    public int solution(int n, String[] data) {
        // DFS를 이용해 8명을 일렬로 세우는 모든 경우의 수 탐색
        dfs("", 0, data);
        
        return answer;
    }
    
    // DFS로 순열 생성
    void dfs(String line, int length, String[] data) {
        // 8명이 모두 배치되었으면 조건 검사
        if (length == 8) {
            checkLine(line, data);
            return;
        }

        // 아직 배치하지 않은 친구를 하나씩 선택
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;                  // 사용 처리
                dfs(line + friends[i], length + 1, data); // 다음 자리 배치
                visited[i] = false;                 // 백트래킹 (원상복구)
            }
        }
    }
    
    // 한 줄(line)이 주어진 조건(data)을 만족하는지 확인
    void checkLine(String line, String[] data) {
        for (String condition : data) {
            
            // 두 친구 사이의 사람 수 계산
            // 예: A와 C 사이에 몇 명 있는지
            int diff = Math.abs(
                line.indexOf(condition.charAt(0)) - 
                line.indexOf(condition.charAt(2))
            ) - 1;
            
            // 조건에서 요구하는 거리
            int gap = condition.charAt(4) - '0';

            // 조건 연산자에 따른 검사
            switch (condition.charAt(3)) {
                case '=': // 정확히 gap 만큼 떨어져 있어야 함
                    if (diff != gap) return;
                    break;
                case '<': // gap 보다 가까워야 함
                    if (diff >= gap) return;
                    break;
                case '>': // gap 보다 멀어야 함
                    if (diff <= gap) return;
                    break;
            }
        }

        // 모든 조건을 만족하면 경우의 수 증가
        answer++;
    }
    
}