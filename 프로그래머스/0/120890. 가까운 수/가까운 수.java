import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int minDiff = Integer.MAX_VALUE;
        int answer = 0;
        
        Arrays.sort(array);
        
        for(int i=0; i<array.length; i++) {
            int diff = Math.abs(n-array[i]);
            if(minDiff > diff) {
                minDiff = diff;
                answer = array[i];
            }else if(n < array[i] && minDiff < diff) {
                break;
            }
        }
        
        return answer;
    }
}