import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, Comparator.comparing((int[] o) -> o[1])
                .thenComparing(o -> o[0]));

        int end = targets[0][1];
        answer++;

        for(int i=1; i<targets.length; i++) {
            if(end <= targets[i][0]) {
                end = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}