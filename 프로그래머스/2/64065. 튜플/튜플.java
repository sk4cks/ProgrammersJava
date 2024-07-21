import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        Map<Integer,Integer> map = new HashMap<>();
       String newS = s.replaceAll("[{}]","");
        String[] sArray = newS.split(",");

        for(int i=0; i< sArray.length; i++){
            map.put(Integer.parseInt(sArray[i]),
                    map.getOrDefault(Integer.parseInt(sArray[i]),0)+1);
        }
        List<Integer> answer = new ArrayList<>(map.keySet());
        Collections.sort(answer, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        return answer;
    }
}