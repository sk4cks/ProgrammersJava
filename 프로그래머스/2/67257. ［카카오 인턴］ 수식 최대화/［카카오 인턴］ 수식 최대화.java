import java.util.*;

class Solution {
    long answer = 0;                 // 최종 결과 (절댓값 최대)
    String[] ops = {"+", "-", "*"}; // 사용할 연산자 목록
    boolean[] used = new boolean[3]; // 각 연산자를 이미 우선순위에 사용했는지 체크

    public long solution(String expression) {
        /*
         [1] 문자열을 숫자 / 연산자로 분리
         예: "100-200*300-500+20"
         → ["100", "-", "200", "*", "300", "-", "500", "+", "20"]

         정규식:
         (?<=[-+*]) : 연산자 뒤
         (?=[-+*])  : 연산자 앞
        */
        List<String> tokens = new ArrayList<>(
            Arrays.asList(expression.split("(?<=[-+*])|(?=[-+*])"))
        );

        // DFS 시작 (연산자 우선순위 결정)
        dfs(tokens, 0);

        return answer;
    }

    /*
     [DFS]
     - depth: 현재까지 선택한 연산자 우선순위 개수
     - tokens: 현재 상태의 수식 (계산이 일부 진행된 상태일 수도 있음)

     핵심:
     "연산자 하나 선택 → 해당 연산 먼저 전부 처리 → 다음 단계"
    */
    void dfs(List<String> tokens, int depth) {

        /*
         [종료 조건]
         3개의 연산자 우선순위를 모두 정한 경우
         → 계산이 끝난 상태 (tokens에는 결과 하나만 남음)
        */
        if (depth == 3) {
            long result = Math.abs(Long.parseLong(tokens.get(0)));
            answer = Math.max(answer, result);
            return;
        }

        // 3개의 연산자 중 아직 사용하지 않은 것을 선택
        for (int i = 0; i < 3; i++) {
            if (used[i]) continue;

            used[i] = true;

            /*
             [중요] 현재 상태 복사
             - List는 참조형이라 그대로 쓰면 다른 DFS에 영향 줌
             - 반드시 복사해서 독립적인 계산 수행
            */
            List<String> next = new ArrayList<>(tokens);

            String op = ops[i]; // 이번 단계에서 우선 적용할 연산자

            /*
             [핵심 로직]
             선택한 연산자를 "전부 먼저 처리"

             예:
             100 - 200 * 300 - 500 + 20
             만약 "*" 먼저면:
             → 100 - (200*300) - 500 + 20
            */
            for (int j = 0; j < next.size(); ) {

                // 현재 위치가 우리가 선택한 연산자라면
                if (next.get(j).equals(op)) {

                    // 연산자 기준으로 앞/뒤 숫자 추출
                    long prev = Long.parseLong(next.get(j - 1));
                    long nextNum = Long.parseLong(next.get(j + 1));

                    // 실제 연산 수행
                    long res = calc(prev, nextNum, op);

                    /*
                     [리스트 수정]
                     prev op next → result 로 치환

                     예:
                     [100, -, 200, *, 300]
                     → [100, -, 60000]
                    */
                    next.set(j - 1, String.valueOf(res)); // 결과 덮어쓰기
                    next.remove(j);   // 연산자 제거
                    next.remove(j);   // 뒤 숫자 제거

                    // j는 그대로 유지 (앞 요소로 바뀌었기 때문)
                } else {
                    j++; // 다른 연산자는 건너뜀
                }
            }

            // 다음 연산자 우선순위 선택
            dfs(next, depth + 1);

            // 백트래킹 (사용 여부 원복)
            used[i] = false;
        }
    }

    /*
     [연산 수행 함수]
     - 두 숫자와 연산자를 받아 결과 반환
    */
    long calc(long a, long b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        return a * b;
    }
}