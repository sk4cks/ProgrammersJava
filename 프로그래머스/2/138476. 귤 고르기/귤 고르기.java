import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> countList = new ArrayList<>();
        int count = 0;
        int answer = 0;
        
        for(int i=0; i< tangerine.length; i++){
            map.put(tangerine[i],map.get(tangerine[i]) == null? 1 : map.get(tangerine[i])+1);
        }
        for(Integer key : map.keySet()){
            countList.add(map.get(key));
        }
        Collections.sort(countList,Collections.reverseOrder());

        for(int i=0; i<countList.size(); i++){
            count+=countList.get(i);
            answer++;
            if(count >= k) break;
        }
        return answer;
    }
}