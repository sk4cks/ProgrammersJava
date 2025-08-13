import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
            
            while (stack.size()>=2
                    && stack.get(stack.size()-1)==stack.get(stack.size()-2)){
                stack.pop();
                stack.pop();
            }
        }
        
        if(stack.size()==0) {
            answer = 1;
        }

        return answer;
    }
}