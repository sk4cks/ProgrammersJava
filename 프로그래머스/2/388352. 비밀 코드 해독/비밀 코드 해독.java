import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        // 1~n 중에서 5개를 고르는 모든 조합을 저장할 리스트
        List<int[]> combinations = new ArrayList<>();
        // 조합 생성 시작
        generateCombinations(n, 5, 1, new int[5], 0, combinations);

        // 생성된 모든 조합을 하나씩 확인
        for (int[] candidate : combinations) {
            // 후보 조합을 Set으로 변환 (포함 여부 빠르게 확인하기 위해)
            Set<Integer> code = new HashSet<>();
            for (int c : candidate) code.add(c);

            boolean valid = true; // 조건 만족 여부
            // 모든 질문 q[i]에 대해 검사
            for (int i = 0; i < q.length; i++) {
                int match = 0; // 현재 질문에서 겹치는 숫자 개수
                for (int num : q[i]) {
                    if (code.contains(num)) match++; // 후보 코드에 있으면 카운트
                }
                // 겹치는 개수가 ans[i]와 다르면 조건 불만족
                if (match != ans[i]) {
                    valid = false;
                    break;
                }
            }
            // 모든 조건을 만족했다면 유효한 코드 → 카운트 증가
            if (valid) answer++;
        }
        
        return answer;
    }
    
    /**
     * 조합 생성 함수
     * n까지 숫자(1~n) 중에서 r개를 뽑아 조합을 만드는 재귀 함수
     */
    private void generateCombinations(int n, int r, int start, int[] temp, int depth, List<int[]> result) {
        // 5개를 다 뽑았으면 결과 리스트에 추가
        if (depth == r) {
            result.add(temp.clone()); // clone() 안 하면 참조 공유됨
            return;
        }
        // 현재 자리(depth)에 들어갈 숫자를 start~n까지 반복
        for (int i = start; i <= n; i++) {
            temp[depth] = i; // 숫자 선택
            generateCombinations(n, r, i + 1, temp, depth + 1, result); // 다음 자리 채우기
        }
    }
}