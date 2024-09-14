import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = 
            Arrays.stream(numbers).boxed().collect(Collectors.toList());
        int[] arr = new int[10];

        for(int i=1; i<arr.length; i++){
            arr[i] = i;
        }

        for(int i=0; i<arr.length; i++){
           if(list.indexOf(arr[i]) < 0) answer += arr[i] ;
        }
        
        return answer;
    }
}