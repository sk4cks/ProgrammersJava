import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        Map<String,String> baseMap = new HashMap<>();
        int answer = 0;
        
        baseMap.put("]","[");
        baseMap.put(")","(");
        baseMap.put("}","{");
        
        for(int i=0; i<s.length(); i++){
            stack.clear();
            for(int j=0; j<s.length(); j++){
                String x = String.valueOf(s.charAt((i+j)%s.length()));

                if(stack.isEmpty() || baseMap.get(x) == null){
                    stack.add(x);
                }else if(baseMap.get(x).equals(stack.peek())){
                    stack.pop();
                }
            }
            if(stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}