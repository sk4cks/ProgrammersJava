import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.asList(strings).stream()
            .sorted(Comparator.comparing((String a) -> a.charAt(n))
                    .thenComparing(a -> a))
            .toArray(String[]::new);
        
        return answer;
    }
}