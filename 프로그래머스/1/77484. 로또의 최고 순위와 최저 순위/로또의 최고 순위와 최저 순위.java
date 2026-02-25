import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zeroCount = 0;   // 0의 개수
        int matchCount = 0;  // 실제로 맞은 개수
        
        // 당첨 번호를 Set에 넣어서 탐색을 빠르게 함 (O(1))
        Set<Integer> winSet = new HashSet<>();
        for(int num : win_nums) {
            winSet.add(num);
        }
        
        for(int num : lottos) {
            if(num == 0) {
                zeroCount++;
            } else if(winSet.contains(num)) {
                matchCount++;
            }
        }
        
        // 최고 순위 (0이 전부 맞았다고 가정)
        int maxRank = Math.min(7 - (matchCount + zeroCount), 6);
        
        // 최저 순위 (실제 맞은 개수 기준)
        int minRank = Math.min(7 - matchCount, 6);
        
        return new int[]{maxRank, minRank};
    }
}