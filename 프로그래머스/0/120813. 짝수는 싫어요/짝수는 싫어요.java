import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=n; i++) {
            if(i%2==1) list.add(i);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}