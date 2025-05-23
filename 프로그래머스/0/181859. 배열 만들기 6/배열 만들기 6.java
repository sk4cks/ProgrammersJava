import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int[] answer = {-1};
        
        for(int i=0; i<arr.length; i++) {
            if(!stk.isEmpty() && stk.get(stk.size()-1) == arr[i]) {
                stk.remove(stk.size()-1);
            }else{
                stk.add(arr[i]);
            }
        }

        if(!stk.isEmpty()) {
            answer = stk.stream().mapToInt(i->i).toArray();
        }
        
        return answer;
    }
}