import java.util.*;

class Solution {
    Stack<String> stack = new Stack<>();
    String[][] operMu;
    String[] operArr;
    boolean[] checked;
    int operIndex = 0;
    int factorial = 1;
    long answer = Long.MIN_VALUE;
    
    public long solution(String expression) {
        String[] expArr = expression.split("(?<=[-+*])|(?=[-+*])");
        operArr = expression.replaceAll("\\d","").split("");
        operArr = Arrays.stream(operArr).distinct().toArray(String[]::new);
        checked = new boolean[operArr.length];

        for(int i=1; i<=operArr.length; i++) {
            factorial *= i;
        }
        operMu = new String[factorial][operArr.length];
        permutation(operArr.length);

        for(int i=0; i<operMu.length; i++) {
            List<String> list = new ArrayList<>(Arrays.asList(expArr));
            for(int j=0; j<operMu[i].length; j++) {
                while (true) {
                    int index = list.indexOf(operMu[i][j]);
                    if(index == -1) break;
                    calc(list,index);
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(list.get(0))));
        }
        
        return answer;
    }
    
    void permutation(int n) {
        if(stack.size() == n) {
            operMu[operIndex++] = stack.toArray(new String[0]);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!checked[i]) {
                checked[i] = true;
                stack.push(operArr[i]);
                permutation(n);
                stack.pop();
                checked[i] = false;
            }
        }
    }
    
    void calc(List<String> list, int index) {
        long prev = Long.parseLong(list.get(index-1));
        String oper = list.get(index);
        long next = Long.parseLong(list.get(index+1));
        long result = 0;

        switch (oper) {
            case "+":
                result = prev + next;
                break;
            case "-":
                result = prev - next;
                break;
            case "*":
                result = prev * next;
                break;
        }
        list.set(index-1, String.valueOf(result));
        list.remove(index);
        list.remove(index);
    }
}