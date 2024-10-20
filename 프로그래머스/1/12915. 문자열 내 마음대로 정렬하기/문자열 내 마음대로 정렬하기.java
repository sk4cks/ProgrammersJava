import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, Comparator.comparing((String a) -> a.charAt(n))
                    .thenComparing(a -> a));
        
        return strings;
    }
}