import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0; // 필요한 요격 횟수
        int end = 0;    // 마지막으로 요격한 미사일의 종료 지점

        // 1. 미사일을 '끝 지점' 기준으로 오름차순 정렬
        //    → 가장 빨리 끝나는 미사일부터 처리하는 그리디 전략
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        // 2. 정렬된 미사일들을 순회
        for (int i = 0; i < targets.length; i++) {
            
            // 3. 이전 요격 지점(end)으로 현재 미사일을 요격할 수 없는 경우
            //    (현재 미사일의 시작점이 end 이상이면 겹치지 않음)
            if (end <= targets[i][0]) {
                
                // 4. 새로운 요격 미사일 발사
                //    → 현재 미사일의 끝 지점에서 요격
                end = targets[i][1];
                
                // 5. 요격 횟수 증가
                answer++;
            }
        }
        
        // 6. 최소 요격 횟수 반환
        return answer;
    }
}