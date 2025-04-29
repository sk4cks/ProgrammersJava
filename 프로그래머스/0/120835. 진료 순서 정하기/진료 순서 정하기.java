import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        List<Integer> copyArr = IntStream.of(emergency)
            .boxed()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());

        for(int i=0; i<emergency.length; i++) {
            answer[i] = copyArr.indexOf(emergency[i]) + 1;
        }
        
        return answer;
    }
}