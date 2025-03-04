import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();

        for(int i=0; i<my_string.length(); i++) {
            list.add(my_string.substring(i,my_string.length()));
        }
        
        return list.stream().sorted().toArray(String[]::new);
    }
}