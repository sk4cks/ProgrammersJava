import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String,Integer> map = new HashMap<>();

        for(int i=0; i<keymap.length; i++){
            String[] key = keymap[i].split("");
            for(int j=0; j<key.length; j++){
                if(map.get(key[j])==null || map.get(key[j]) > j+1){
                    map.put(key[j],j+1);
                }
            }
        }

        for(int i=0; i<targets.length; i++){
            String[] target = targets[i].split("");
            for(int j=0;j<target.length; j++){
                if(map.get(target[j])==null){
                    answer[i] = -1;
                    break;
                }else{
                    answer[i] += map.get(target[j]);
                }
            }
        }
        return answer;
    }
}