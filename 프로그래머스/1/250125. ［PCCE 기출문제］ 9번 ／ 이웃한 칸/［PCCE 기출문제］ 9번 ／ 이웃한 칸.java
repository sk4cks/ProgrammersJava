class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        // 보드 한 변의 길이 (정사각형)
        int n = board.length;
        
        // 상하좌우 이동을 위한 방향 배열
        // (오른쪽, 아래, 위, 왼쪽)
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        // 4방향 탐색
        for(int i = 0; i < dh.length; i++){
            
            // 이동한 위치 계산
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            // 배열 범위를 벗어나지 않는지 확인
            if(h_check >= 0 && h_check < n &&
               w_check >= 0 && w_check < n){
                
                // 현재 위치와 이동한 위치의 값이 같은지 비교
                if(board[h][w].equals(board[h_check][w_check])){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}