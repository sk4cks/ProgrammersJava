import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array) {
        List<Integer> list = IntStream.of(array)
            .boxed().collect(Collectors.toList());

        Arrays.sort(array);
        
        int[] answer = {array[array.length-1],list.indexOf(array[array.length-1])};
        
        return answer;
    }
}