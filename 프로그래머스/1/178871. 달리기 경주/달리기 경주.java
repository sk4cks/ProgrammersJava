import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수 이름 -> 현재 순위를 저장하는 Map
        Map<String, Integer> map = new HashMap<>();
        
        // 초기 선수들의 순위를 Map에 세팅
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        // 불린(callings) 순서대로 추월 처리
        for(int i=0; i< callings.length; i++){
            
            // 불린 선수의 현재 순위 조회
            int rank = map.get(callings[i]);
            
            // 바로 앞에 있던 선수 (추월 당하는 선수)
            String changePlayer = players[rank-1];

            // 두 선수의 위치를 배열에서 서로 교환
            players[rank] = changePlayer;
            players[rank-1] = callings[i];

            // Map에도 변경된 순위를 즉시 반영
            map.put(changePlayer, rank);
            map.put(callings[i], rank-1);
        }
        
        // 최종 순위 배열 반환
        return players;
    }
}