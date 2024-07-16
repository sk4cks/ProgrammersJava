import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        for(int i=0; i< topping.length;i++){
            right.put(topping[i],right.getOrDefault(topping[i],0)+1);
        }
        for(int i=0; i< topping.length; i++){
            right.put(topping[i],right.get(topping[i])-1);
            left.add(topping[i]);
            
            if(right.get(topping[i])==0) right.remove(topping[i]);
            
            if(left.size()== right.size()) answer++;
            else if(left.size() > right.size()) break;
        }
        
        return answer;
    }
}