import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Character> list = s.chars().mapToObj(c -> (char) c)
            .collect(Collectors.toList());
        list.sort(Collections.reverseOrder());
        
        return list.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
    }
}