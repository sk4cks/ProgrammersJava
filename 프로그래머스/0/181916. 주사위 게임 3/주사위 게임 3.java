import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        map.put(a,map.getOrDefault(a,0) + 1);
        map.put(b,map.getOrDefault(b,0) + 1);
        map.put(c,map.getOrDefault(c,0) + 1);
        map.put(d,map.getOrDefault(d,0) + 1);
        
        switch (map.size()) {
            case 1:
                answer = 1111*a;
                break;
            case 2:
                int[] arr = new int[2];
                int index = 0;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    switch (entry.getValue()) {
                        case 1:
                            answer += entry.getKey();
                            break;
                        case 2:
                            arr[index++] = entry.getKey();
                            break;
                        case 3:
                            answer += 10 * entry.getKey();
                            break;
                    }

                }
                if(index > 0) {
                    answer = (arr[0] + arr[1]) * Math.abs(arr[0]-arr[1]);
                }else{
                    answer = (int) Math.pow(answer,2);
                }
                break;
            case 3:
                answer = 1;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == 1) {
                        answer *= entry.getKey();
                    }
                }
                break;
            case 4:
                answer = Integer.MAX_VALUE;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                       answer = Math.min(entry.getKey(), answer);
                }
                break;
        }
        
        return answer;
    }
}