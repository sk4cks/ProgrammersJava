import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<intStrs.length; i++) {
            int intStr = Integer.parseInt(intStrs[i].substring(s,s+l));
            if(intStr > k) {
                list.add(intStr);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}