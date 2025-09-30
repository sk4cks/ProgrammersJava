import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        // 첫 번째 행 이후부터 차례대로 내려가면서
        // 각 칸에 올 수 있는 최대 점수를 누적해 나간다
        for(int i=1; i<land.length; i++){
            // 현재 행의 각 열(j)에 대해 계산한다
            for(int j=0; j<land[i].length; j++){
                int value = 0;  // 이전 행에서 고를 수 있는 최댓값을 담을 변수
                
                // 바로 위 행을 훑으면서,
                // 같은 열(j)은 제외하고 최댓값을 찾는다
                for(int k=0; k<land[i-1].length; k++){
                    if(k==j) continue;  // 같은 열은 선택 불가
                    value = Math.max(value,land[i-1][k]);
                }
                
                // 현재 칸의 점수에, 위에서 찾은 최댓값을 더해서 누적시킨다
                land[i][j] += value;
            }
        }
        
        // 마지막 행에는 "그 칸까지 왔을 때 얻을 수 있는 최대 점수"가 들어있다.
        // 따라서 마지막 행을 훑으면서 최댓값을 찾으면 전체 최댓값이 된다.
        for (int num : land[land.length - 1]) {
            answer = Math.max(answer, num);
        }

        return answer;
    }
}