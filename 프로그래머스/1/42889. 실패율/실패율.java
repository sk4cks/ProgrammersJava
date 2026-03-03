import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] stageCount = new int[N + 2]; 
        // 각 스테이지에 머물러 있는 사람 수
        
        // 1️⃣ 스테이지별 인원 수 카운트
        for (int s : stages) {
            stageCount[s]++;
        }
        
        int total = stages.length;  // 현재 도전 중인 전체 인원
        double[] failure = new double[N + 1];
        
        // 2️⃣ 실패율 계산 (1번 ~ N번)
        for (int i = 1; i <= N; i++) {
            
            if (total == 0) {
                failure[i] = 0;
            } else {
                failure[i] = (double) stageCount[i] / total;
                total -= stageCount[i]; 
                // 다음 스테이지로 갈수록 도전 인원 감소
            }
        }
        
        // 3️⃣ 스테이지 번호 리스트 생성
        Integer[] result = new Integer[N];
        for (int i = 0; i < N; i++) {
            result[i] = i + 1;
        }
        
        // 4️⃣ 실패율 기준 내림차순 정렬
        Arrays.sort(result, (a, b) -> {
            if (failure[b] == failure[a]) {
                return a - b;  // 실패율 같으면 작은 번호 먼저
            }
            return Double.compare(failure[b], failure[a]);
        });
        
        // 5️⃣ Integer[] → int[] 변환
        return Arrays.stream(result).mapToInt(i -> i).toArray();
    }
}