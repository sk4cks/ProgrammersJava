import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0; // 최종 피로도 합
        
        // 광물별 곡괭이 사용 시 피로도
        // 인덱스: 0=다이아 곡괭이, 1=철 곡괭이, 2=돌 곡괭이
        Map<String, int[]> map = Map.of(
            "diamond",new int[]{1,5,25},
            "iron",new int[]{1,1,5},
            "stone",new int[]{1,1,1}
        );
        
        // 캘 수 있는 최대 그룹 수
        // (광물은 5개씩 묶고, 곡괭이 총 개수만큼만 가능)
        int max = Math.min((minerals.length +4)/5, picks[0]+picks[1]+picks[2]);
        
        // 각 그룹별 곡괭이 사용 시 피로도 합
        // group[i][j] : i번째 그룹을 j번 곡괭이로 캤을 때의 피로도
        int[][] group = new int[max][3];
        
        // 🔹 광물을 5개씩 그룹으로 묶어 피로도 계산
        for (int i=0; i<minerals.length && i/5 < max; i++) {
            int idx = i/5;  // 그룹 인덱스
            int[] arr = map.get(minerals[i]);
            
            // 각 곡괭이별 피로도 누적
            for (int j=0; j<arr.length; j++) {
                group[idx][j] += arr[j];
            }
        }
        
        // 🔹 돌 곡괭이 기준(가장 힘든 경우)으로 내림차순 정렬
        // 어려운 그룹을 먼저 처리 → 좋은 곡괭이를 우선 사용
        Arrays.sort(group, Comparator.comparingInt((int[] o) -> o[2]).reversed());
        
        // 🔹 그룹마다 가장 좋은 곡괭이부터 사용
        for (int i=0; i<group.length; i++) {
            for (int j=0; j<picks.length; j++) {
                if (picks[j] > 0) {
                    answer += group[i][j];  // 해당 곡괭이 사용 시 피로도
                    picks[j]--;             // 곡괭이 소모
                    break;
                }
            }
        }
        
        // 최종 피로도 반환
        return answer;
    }
}