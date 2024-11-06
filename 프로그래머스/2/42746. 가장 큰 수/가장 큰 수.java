import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        List<Integer> result =IntStream.of(numbers)
                .boxed()
                .sorted((a,b) -> (String.valueOf(b)+a).compareTo(String.valueOf(a)+b))
                .collect(Collectors.toList());

        result.forEach(item -> sb.append(item));
        
        if(sb.charAt(0)=='0') return "0";
                
        return sb.toString();
    }
}