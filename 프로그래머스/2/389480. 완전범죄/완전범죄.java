import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {

        // dpArr[i][j] :
        // i번째 물건까지 고려했을 때,
        // B의 누적합이 j일 때 만들 수 있는 A의 최소 합
        int[][] dpArr = new int[info.length + 1][m];

        int INF = 10000;  // 불가능 상태를 나타내는 큰 값
        int answer = INF;

        // DP 배열을 모두 INF로 초기화
        for (int[] arr : dpArr) {
            Arrays.fill(arr, INF);
        }

        // 아무 것도 선택하지 않았을 때 A=0, B=0
        dpArr[0][0] = 0;

        // 1. 물건을 하나씩 고려
        for (int i = 1; i <= info.length; i++) {
            int a = info[i - 1][0]; // A 증가량
            int b = info[i - 1][1]; // B 증가량

            // 2. 가능한 모든 B값(j)에 대해 갱신
            for (int j = 0; j < m; j++) {

                // (선택 1) 이번 물건을 A에 더하는 경우
                // B는 그대로, A만 증가
                dpArr[i][j] = Math.min(
                    dpArr[i][j],
                    dpArr[i - 1][j] + a
                );

                // (선택 2) 이번 물건을 B에 더하는 경우
                // B가 m 미만일 때만 가능
                if (j + b < m) {
                    dpArr[i][j + b] = Math.min(
                        dpArr[i][j + b],
                        dpArr[i - 1][j]
                    );
                }
            }
        }

        // 3. 마지막 물건까지 고려했을 때,
        // B가 m 미만인 모든 경우 중 A의 최소값 찾기
        for (int i = 0; i < m; i++) {
            answer = Math.min(dpArr[info.length][i], answer);
        }

        // 4. A의 최소값이 n 이상이면 조건 만족 불가
        if (answer >= n) {
            answer = -1;
        }

        return answer;
    }
}