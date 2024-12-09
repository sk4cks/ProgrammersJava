import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        for(int i=0; i<course.length; i++) {
            Map<String,Integer> map = new HashMap<>();

            for(int j=0; j<orders.length; j++) {
                if(course[i] <= orders[j].length()) {
                    combine(orders[j],course[i],0,"",map);
                }
            }

            // 최대값 찾기
            int maxValue = map.values().stream()
                    .filter(value -> value > 1 )
                    .max(Integer::compareTo)
                    .orElse(Integer.MIN_VALUE);

            if(maxValue > Integer.MIN_VALUE) {
                // 최대값을 가진 키들 찾기
                List<String> maxKeys = map.entrySet().stream()
                        .filter(entry -> entry.getValue() == maxValue)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

                answer.addAll(maxKeys);
            }
        }
        
        return answer.stream().sorted().toArray(String[]::new);
    }
    
    void combine(String str, int r, int index, String current, Map<String,Integer> map) {
        if (current.length() == r) {
            map.put(current,map.getOrDefault(current,0)+1);
            return;
        }
        if (index >= str.length()) {
            return;
        }
        // Include the current character
        combine(str, r, index + 1, current + str.charAt(index), map);
        // Exclude the current character
        combine(str, r, index + 1, current, map);
    }
}