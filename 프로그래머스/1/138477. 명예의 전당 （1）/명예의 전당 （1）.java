import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        
        // 매일의 명예의 전당 최저 점수를 저장할 배열
        int[] answer = new int[score.length];
        
        // 명예의 전당 (상위 k개의 점수를 유지)
        List<Integer> hof = new ArrayList<>();

        // 날짜별 점수를 순회
        for(int i=0; i<score.length; i++){
            
            // 오늘 점수를 명예의 전당에 추가
            hof.add(score[i]);
            
            // 오름차순 정렬 (작은 값이 앞쪽)
            Collections.sort(hof);
            
            // 명예의 전당 크기가 k를 초과하면
            if(hof.size()>k) 
                // 가장 작은 값 제거 (최하위 탈락)
                hof.remove(0);
            
            // 현재 명예의 전당에서 가장 낮은 점수 저장
            // (정렬되어 있으므로 index 0이 최소값)
            answer[i] = hof.get(0);
        }
        
        // 결과 반환
        return answer;
    }
}