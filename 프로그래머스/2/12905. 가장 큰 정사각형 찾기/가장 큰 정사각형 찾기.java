class Solution
{
    public int solution(int[][] board) {
        int answer = 0;
        
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
        
        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[i].length; j++) {
                if(board[i][j] > 0) {
                    board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j-1]),board[i-1][j]) + 1;
                    answer = Math.max(board[i][j],answer);
                }
            }
        }
        
        return (int) Math.pow(answer,2);
    }
}