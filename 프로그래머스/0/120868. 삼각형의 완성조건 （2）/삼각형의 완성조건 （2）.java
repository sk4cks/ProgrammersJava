import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] sides) {
        int max = Math.max(sides[0],sides[1]) + 1;
        int a = Math.abs(sides[0] - sides[1]) + 1;
        int answer = 0;

        answer += max - a;
        answer += sides[0] + sides[1] - max;
        
        return answer;
    }
}