import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        // 1~n 중 5개를 고르는 모든 조합을 생성
        List<int[]> combinations = new ArrayList<>();
        generateCombinations(n, 5, 1, new int[5], 0, combinations);

        // 각 후보 조합이 조건을 만족하는지 확인
        for (int[] candidate : combinations) {
            Set<Integer> code = new HashSet<>();
            for (int c : candidate) code.add(c);

            boolean valid = true;
            for (int i = 0; i < q.length; i++) {
                int match = 0;
                for (int num : q[i]) {
                    if (code.contains(num)) match++;
                }
                if (match != ans[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) answer++;
        }
        
        return answer;
    }
    
    // n까지 숫자 중 r개를 뽑는 조합 생성
    private void generateCombinations(int n, int r, int start, int[] temp, int depth, List<int[]> result) {
        if (depth == r) {
            result.add(temp.clone());
            return;
        }
        for (int i = start; i <= n; i++) {
            temp[depth] = i;
            generateCombinations(n, r, i + 1, temp, depth + 1, result);
        }
    }
    
}