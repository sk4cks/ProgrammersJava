import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int end = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < targets.length; i++) {
            if (end <= targets[i][0]) {
                end = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}