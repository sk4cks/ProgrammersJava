import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        Map<String, int[]> map = Map.of("diamond",new int[]{1,5,25}, "iron",new int[]{1,1,5}, "stone",new int[]{1,1,1});
        int max = Math.min((minerals.length +4)/5, picks[0]+picks[1]+picks[2]);
        int[][] group = new int[max][3];
        
        for(int i=0; i<minerals.length && i/5 < max; i++) {
            int idx = i/5;
            int[] arr = map.get(minerals[i]);
            for(int j=0; j<arr.length; j++) {
                group[idx][j] += arr[j];
            }
        }
        
        Arrays.sort(group, Comparator.comparingInt((int[] o) -> o[2]).reversed());
        
        for(int i=0; i<group.length; i++) {
            for(int j=0; j<picks.length; j++) {
                if(picks[j] > 0) {
                    answer += group[i][j];
                    picks[j]--;
                    break;
                }
            }
        }
        
        return answer;
    }
}