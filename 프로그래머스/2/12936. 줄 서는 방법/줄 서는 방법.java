import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[n];
        long factorial = 1;
        int idx = 0;
        k--;
        
        for(int i=1; i<=n; i++) {
            factorial *= i;
            list.add(i);
        }

        while (!list.isEmpty()) {
            factorial /= n--;
            int index = (int) (k / factorial);
            answer[idx++] = list.get(index);
            list.remove(index);
            k %= factorial;
        }
        
        return answer;
    }
}