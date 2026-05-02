import java.util.*;

class Solution {
    Stack<String> stack = new Stack<>(); // 순열 생성용 스택
    String[][] operMu;                  // 연산자 우선순위 순열 저장
    String[] operArr;                   // 중복 제거된 연산자 배열
    boolean[] checked;                  // 순열 생성 시 방문 체크
    int operIndex = 0;                  // 순열 저장 인덱스
    int factorial = 1;                  // 연산자 개수 기반 순열 개수
    long answer = Long.MIN_VALUE;       // 최대 절댓값 결과
    
    public long solution(String expression) {
        
        // 숫자와 연산자를 분리 (예: ["100", "-", "200", "*", "300"])
        String[] expArr = expression.split("(?<=[-+*])|(?=[-+*])");
        
        // 연산자만 추출 후 중복 제거 (예: ["-", "*", "+"])
        operArr = expression.replaceAll("\\d","").split("");
        operArr = Arrays.stream(operArr).distinct().toArray(String[]::new);
        
        checked = new boolean[operArr.length];

        // 연산자 개수로 순열 개수(factorial) 계산
        for(int i=1; i<=operArr.length; i++) {
            factorial *= i;
        }
        
        // 순열 저장 배열 초기화
        operMu = new String[factorial][operArr.length];
        
        // 연산자 우선순위 순열 생성
        permutation(operArr.length);

        // 각 우선순위 케이스마다 계산 수행
        for(int i=0; i<operMu.length; i++) {
            
            // 원본 배열 복사 (연산 중 변경되므로)
            List<String> list = new ArrayList<>(Arrays.asList(expArr));
            
            // 우선순위 순서대로 연산 수행
            for(int j=0; j<operMu[i].length; j++) {
                
                // 해당 연산자가 더 이상 없을 때까지 반복
                while (true) {
                    int index = list.indexOf(operMu[i][j]);
                    if(index == -1) break;
                    
                    // 연산 수행
                    calc(list,index);
                }
            }
            
            // 결과값 절댓값 기준 최대값 갱신
            answer = Math.max(answer, Math.abs(Long.parseLong(list.get(0))));
        }
        
        return answer;
    }
    
    // 연산자 우선순위 순열 생성 (DFS)
    void permutation(int n) {
        // 하나의 순열 완성
        if(stack.size() == n) {
            operMu[operIndex++] = stack.toArray(new String[0]);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!checked[i]) {
                checked[i] = true;
                stack.push(operArr[i]); // 연산자 선택
                permutation(n);         // 다음 단계
                stack.pop();            // 원복 (백트래킹)
                checked[i] = false;
            }
        }
    }
    
    // 실제 연산 수행
    void calc(List<String> list, int index) {
        // index 기준으로 앞 숫자, 연산자, 뒤 숫자 추출
        long prev = Long.parseLong(list.get(index-1));
        String oper = list.get(index);
        long next = Long.parseLong(list.get(index+1));
        long result = 0;

        // 연산 수행
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

        /*
         연산 결과로 치환
         예: [100, -, 200] → [ -100 ]
        */
        list.set(index-1, String.valueOf(result));
        list.remove(index);   // 연산자 제거
        list.remove(index);   // 뒤 숫자 제거
    }
}