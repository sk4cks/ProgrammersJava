import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        int lastNum = num_list[num_list.length-1];
        int lastPrevNum = num_list[num_list.length-2];
        
        List<Integer> list = 
            Arrays.stream(num_list).boxed().collect(Collectors.toList());
        list.add(lastNum > lastPrevNum ? lastNum - lastPrevNum : lastNum*2);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}