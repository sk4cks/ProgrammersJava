import java.util.*;

class Solution {
    public String solution(String s) {
        Map<String,Integer> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                sb.append(key);
            }
        }
        
        return sb.toString();
    }
}