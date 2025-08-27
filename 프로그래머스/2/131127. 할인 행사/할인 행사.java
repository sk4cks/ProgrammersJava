import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> copyMap = new HashMap<>();

        for(int i=0; i<want.length; i++){
            map.put(want[i],number[i]);
        }

        for(int i=0; i< discount.length-9; i++){
            boolean flag = false;
            copyMap = new HashMap<>(map);
            
            for(int j=0; j<10; j++){
                if(copyMap.getOrDefault(discount[i+j],0) <= 0) break;
                
                copyMap.put(discount[i+j], copyMap.get(discount[i+j]) - 1 );

                if(j==9) flag = true;
            }
            if(flag) answer++;
        }
        return answer;
    }
}