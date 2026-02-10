import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 바구니 역할을 하는 스택 (뽑은 인형을 담음)
        Stack<Integer> stack = new Stack<>();

        // moves 순서대로 크레인을 작동
        for(int i = 0; i < moves.length; i++){
            
            // 선택한 열 (1번부터 시작하므로 -1)
            int col = moves[i] - 1;
            
            // 해당 열의 위에서부터 인형 탐색
            for(int j = 0; j < board.length; j++){
                
                // 인형이 있는 경우 (0이 아님)
                if(board[j][col] != 0){
                    
                    // 인형을 스택에 넣고, 보드에서는 제거
                    stack.push(board[j][col]);
                    board[j][col] = 0;

                    // 스택의 맨 위 두 개가 같은 인형이면 제거
                    while (stack.size() >= 2 &&
                           stack.get(stack.size()-1) == stack.get(stack.size()-2)){
                        
                        stack.pop();
                        stack.pop();
                        
                        // 제거된 인형 개수 누적
                        answer += 2;
                    }
                    
                    // 인형을 하나 집었으므로 다음 move로 이동
                    break;
                }
            }
        }
        
        // 최종 제거된 인형 수 반환
        return answer;
    }
}