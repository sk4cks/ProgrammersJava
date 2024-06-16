import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
        }
        
        for(int i=0;i< callings.length; i++){
            int rank = map.get(callings[i]);
            String changePlayer = players[rank-1];

            players[rank] = changePlayer;
            players[rank-1] = callings[i];

            map.put(changePlayer,rank);
            map.put(callings[i],rank-1);
        }
        return players;
    }
}