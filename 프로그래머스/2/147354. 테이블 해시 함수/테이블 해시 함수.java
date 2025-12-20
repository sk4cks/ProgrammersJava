import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0; // 최종 해시값 (XOR 누적 결과)
        row_begin--;    // row_begin을 0-based index로 변환
        
        // 1️⃣ 데이터 정렬
        //  - col 번째 컬럼 기준 오름차순
        //  - col 값이 같으면 첫 번째 컬럼 기준 내림차순
        Arrays.sort(data, (a, b) -> {
            int cmp = Integer.compare(a[col-1], b[col-1]);
            return cmp != 0 ? cmp : Integer.compare(b[0], a[0]);
        });
        
        // 2️⃣ row_begin ~ row_end 구간 처리
        for(int i=row_begin; i<row_end; i++) {
            int finalI = i + 1; // 문제 조건상 i는 1부터 시작하므로 (0-based 보정)
            
            // 현재 행의 모든 값에 대해
            // (값 % 행번호)의 합을 구한 뒤
            // 이전 결과와 XOR 연산 수행
            answer ^= Arrays.stream(data[i]).map(item -> item % finalI).sum();
        }
        
        // 최종 해시값 반환
        return answer;
    }
}