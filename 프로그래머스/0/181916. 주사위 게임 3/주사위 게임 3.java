import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = {a,b,c,d};
        Arrays.sort(arr);
        
        for(int key : arr) {
            map.put(key, map.getOrDefault(key,0) + 1);
        }
        
        switch (map.size()) {
            case 1:
                answer = 1111*a;
                break;
            case 2:
                if(arr[1] != arr[2]) {
                    answer = (arr[1] + arr[2]) * Math.abs(arr[1] - arr[2]);
                }else {
                    answer = (int) Math.pow(10 * arr[1] + (arr[0] + arr[3] - arr[1]),2);
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
                answer = arr[0];
                break;
        }
        
        return answer;
    }
}