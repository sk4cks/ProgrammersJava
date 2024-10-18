import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Character> list = s.chars().mapToObj(c -> (char) c)
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
        
        return list.stream().map(c -> String.valueOf(c))
            .collect(Collectors.joining());
    }
}