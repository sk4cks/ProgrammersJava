import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();


        for(int i=0; i<moves.length; i++){
            int col = moves[i]-1;
            for(int j=0; j<board.length; j++){
                if(board[j][col] != 0){
                    stack.push(board[j][col]);
                    board[j][col] = 0;

                    while (stack.size()>=2 &&
                           stack.get(stack.size()-1) == stack.get(stack.size()-2)){
                        stack.pop();
                        stack.pop();
                        answer+=2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}