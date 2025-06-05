import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] sides) {
        Set<Integer> set = new HashSet<>();

        int max = Math.max(sides[0],sides[1]) + 1;
        int a = Math.abs(sides[0] - sides[1]) + 1;

        while (a < max) {
            set.add(a++);
        }

        while (max < sides[0] + sides[1]) {
            set.add(max++);
        }
        
        return set.size();
    }
}