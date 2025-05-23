import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        int answer = 1;

        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1)+1);
        }

        answer = map.values().stream().reduce(answer,(a,b) -> a*b);
        
        return --answer;
    }
}