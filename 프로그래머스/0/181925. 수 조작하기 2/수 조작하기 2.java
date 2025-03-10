import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        Map<Integer,String> map = Map.of(1,"w",-1,"s",10,"d",-10,"a");
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<numLog.length; i++) {
            sb.append(map.get(numLog[i]-numLog[i-1]));
        }
        
        return sb.toString();
    }
}