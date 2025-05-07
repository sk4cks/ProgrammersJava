import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        int min = list.indexOf(2);
        int max = list.lastIndexOf(2);
        int[] answer = {};
        
        if(min == -1) {
            answer = new int[]{-1};
        }else{
            answer = Arrays.copyOfRange(arr,min,max+1);
        }
        
        return answer;
    }
}