import java.util.*;

class Solution {
    long answer = 0;
    String[] ops = {"+", "-", "*"};
    boolean[] used = new boolean[3];

    public long solution(String expression) {
        // 숫자/연산자 분리
        List<String> tokens = new ArrayList<>(
            Arrays.asList(expression.split("(?<=[-+*])|(?=[-+*])"))
        );

        dfs(tokens, 0);
        return answer;
    }

    // DFS로 연산자 우선순위 선택
    void dfs(List<String> tokens, int depth) {
        if (depth == 3) {
            long result = Math.abs(Long.parseLong(tokens.get(0)));
            answer = Math.max(answer, result);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (used[i]) continue;

            used[i] = true;

            // 현재 상태 복사 (중요)
            List<String> next = new ArrayList<>(tokens);

            // 선택한 연산자 먼저 처리
            String op = ops[i];
            for (int j = 0; j < next.size(); ) {
                if (next.get(j).equals(op)) {
                    long prev = Long.parseLong(next.get(j - 1));
                    long nextNum = Long.parseLong(next.get(j + 1));
                    long res = calc(prev, nextNum, op);

                    // 계산 결과로 치환
                    next.set(j - 1, String.valueOf(res));
                    next.remove(j);   // 연산자 제거
                    next.remove(j);   // 숫자 제거
                } else {
                    j++;
                }
            }

            // 다음 연산자 선택
            dfs(next, depth + 1);

            used[i] = false;
        }
    }

    long calc(long a, long b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        return a * b;
    }
}