class Solution {
    int[] board;    // board[i] = i번째 행에 놓인 퀸의 열 위치
    int answer;     // 가능한 경우의 수
    
    public int solution(int n) {
        board = new int[n]; // 크기 n의 체스판 준비
        backTracking(0,n);  // 0번째 행부터 퀸 배치 시작
        
        return answer;  // 모든 경우의 수 반환
    }
    
    // depth : 현재 퀸을 놓을 행 번호
    void backTracking(int depth, int n) {
        
        // 모든 행에 퀸을 성공적으로 배치한 경우
        if(depth == n) {
            answer++;
            return;
        }

        // 현재 행(depth)에 대해 모든 열에 퀸을 놓아봄
        for(int i=0; i<n; i++) {
            board[depth] = i;   // depth 행의 i열에 퀸 배치
            
            // 이전 퀸들과 충돌하지 않으면 다음 행으로 진행
            if(valid(depth)) {
                backTracking(depth+1, n);
            }
        }
    }
    
    // 현재 depth 행에 놓은 퀸이 유효한지 검사
    boolean valid(int depth) {
        
        // 이전 행들에 놓인 퀸들과 비교
        for(int i=0; i<depth; i++) {
            
            // 같은 열에 퀸이 있는 경우
            if(board[i] == board[depth]) return false;
            
            // 행 차이 == 열 차이 → 같은 대각선
            if(Math.abs(i-depth) == Math.abs(board[i] - board[depth])) return false;
        }

        // 충돌 없음 → 유효한 배치
        return true;
    }
}