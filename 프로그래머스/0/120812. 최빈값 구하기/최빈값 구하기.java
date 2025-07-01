import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxCount = 0;
        int answer = 0;
        
        for(int i=0; i<array.length; i++) {
            int count = map.getOrDefault(array[i],0) + 1;
            map.put(array[i],count);

            if(maxCount < count) {
                maxCount = count;
                answer = array[i];
            }else if(maxCount == count) {
                answer = -1;
            }
        }
        
        return answer;
    }
}