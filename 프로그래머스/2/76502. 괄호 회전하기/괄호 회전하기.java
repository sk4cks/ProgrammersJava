import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        Map<String,String> baseMap = new HashMap<>();
        int answer = 0;
        
        baseMap.put("]","[");
        baseMap.put(")","(");
        baseMap.put("}","{");
        
        //i칸 회전
        for(int i=0; i<s.length(); i++){
            //새로운 회전을 검증할때 스택 초기화
            stack.clear();
            
            for(int j=0; j<s.length(); j++){
                
                //인덱스를 회전시켜서 i칸 회전한 문자열을 순회함.
                String x = String.valueOf(s.charAt((i+j)%s.length()));

                //스택이 비어있거나 여는 괄호면 푸시
                if(stack.isEmpty() || baseMap.get(x) == null){
                    stack.push(x);
                    
                //스택의 맨 위가 짝이 맞는 여는 괄호면 팝
                }else if(baseMap.get(x).equals(stack.peek())){
                    stack.pop();
                    
                //아니면 잘못된 괄호
                }else{
                    break;
                }
            }
            
            //한 번의 회전 검사 끝에 스택이 비어있다면 올바른 괄호
            if(stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}