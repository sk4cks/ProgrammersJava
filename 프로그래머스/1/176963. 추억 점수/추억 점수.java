import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> map = new HashMap<>();
        int[] answer = new int[photo.length];
        
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }

        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                answer[i] += 
                    ( map.get(photo[i][j]) == null ? 0 : map.get(photo[i][j]) );
            }
        }
        return answer;
    }
}