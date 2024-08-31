import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                int value = 0;
                for(int k=0; k<land[i-1].length; k++){
                    if(k==j) continue;
                    value = Math.max(value,land[i-1][k]);
                }
                land[i][j] += value;
            }
        }
        Arrays.sort(land[land.length-1]);
        answer = land[land.length-1][3];

        return answer;
    }
}