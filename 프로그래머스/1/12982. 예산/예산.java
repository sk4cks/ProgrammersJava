import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int total = 0;
        
        Arrays.sort(d);

        for(int i=0; i<d.length; i++){
            total += d[i];
            if(total > budget) return i;
        }
        
        answer = d.length;
        return answer;
    }
}