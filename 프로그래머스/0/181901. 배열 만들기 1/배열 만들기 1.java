import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int multiple = 1;

        while (k*multiple <= n){
            list.add(k*multiple++);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}