import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();


        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        answer = set.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}