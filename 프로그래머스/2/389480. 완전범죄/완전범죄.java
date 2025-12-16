import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dpArr = new int[info.length+1][m];
        int INF = 10000;
        int answer = INF;

        for (int[] arr : dpArr) {
            Arrays.fill(arr, INF);
        }
        
        dpArr[0][0] = 0;
        
        for (int i=1; i<=info.length; i++) {
            int a = info[i-1][0];
            int b = info[i-1][1];

            for (int j=0; j<m; j++) {
                dpArr[i][j] = Math.min(dpArr[i][j], dpArr[i-1][j] + a);

                if (j + b < m) {
                    dpArr[i][j+b] = Math.min(dpArr[i][j+b], dpArr[i-1][j]);
                }
            }
        }
        
        for (int i=0; i< m; i++) {
            answer = Math.min(dpArr[info.length][i], answer);
        }

        if (answer >= n) {
            answer = -1;
        }
        
        return answer;
    }
}