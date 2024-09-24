import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Double> stageMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i< stages.length; i++){
            map.put(stages[i],map.getOrDefault(stages[i],0)+1);
        }

        for(int i=1; i<=N; i++){
            double failureRate = 0;
            int count = 0;
           for(int key : map.keySet()){
               if(i <= key) count += map.get(key);
           }
           int failCount = map.getOrDefault(i,0);

           if(count !=0 && failCount != 0) failureRate = (double) failCount/count;

            stageMap.put(i,failureRate);
            list.add(i);
        }

        list.sort((a,b) -> stageMap.get(b).compareTo(stageMap.get(a)));

        answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}