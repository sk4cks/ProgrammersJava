import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char value = s.charAt(i);

            if (stack.size()>0 && stack.peek()=='(' && value==')') stack.pop();
            else stack.push(value);
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}