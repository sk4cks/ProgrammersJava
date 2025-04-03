import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] answer = Arrays.stream(myString.split("x"))
            .sorted()
            .filter(s -> !s.isEmpty())
            .toArray(String[]::new);
        
        return answer;
    }
}