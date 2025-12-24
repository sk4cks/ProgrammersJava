class Solution
{
    public int solution(int[][] board) {
        int answer = 0; // 가장 큰 정사각형의 한 변 길이
        
        // 🔹 예외 처리
        // 행이나 열이 1인 경우에는
        // 1이 하나라도 있으면 최대 정사각형 넓이는 1
        if(board.length < 2 || board[0].length < 2) {
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[i].length; j++) {
                    if(board[i][j] == 1) {
                        return ++answer;
                    }
                }
            }
            return answer;
        }
        
        // 🔹 DP 진행
        // (i, j)를 오른쪽 아래 꼭짓점으로 하는
        // 가장 큰 정사각형의 한 변 길이를 board[i][j]에 저장
        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[i].length; j++) {
                
                // 현재 위치가 1일 때만 정사각형 확장 가능
                if(board[i][j] > 0) {
                    
                    // 왼쪽, 위, 왼쪽 위 값 중 최소값 + 1
                    board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j-1]),board[i-1][j]) + 1;
                    
                    // 최대 변 길이 갱신
                    answer = Math.max(board[i][j],answer);
                }
            }
        }
        
        // 정사각형의 넓이 = (변 길이)^2
        return (int) Math.pow(answer,2);
    }
}