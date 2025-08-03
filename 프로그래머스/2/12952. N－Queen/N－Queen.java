class Solution {
    int[] board;
    int answer;
    
    public int solution(int n) {
        board = new int[n];
        backTracking(0,n);
        
        return answer;
    }
    
    void backTracking(int depth, int n) {
        if(depth == n) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            board[depth] = i;
            if(valid(depth)) {
                backTracking(depth+1, n);
            }
        }
    }
    
    boolean valid(int depth) {
        for(int i=0; i<depth; i++) {
            if(board[i] == board[depth]) return false;
            if(Math.abs(i-depth) == Math.abs(board[i] - board[depth])) return false;
        }

        return true;
    }
}