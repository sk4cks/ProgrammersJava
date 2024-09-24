import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer,Integer> map = new HashMap<>();
        List<Map<String,Double>> list = new ArrayList<>();

        for(int i=0; i< stages.length; i++){
            map.put(stages[i],map.getOrDefault(stages[i],0)+1);
        }

        for(int i=1; i<=N; i++){
            Map<String,Double> stage = new HashMap<>();
            double failureRate = 0;
            int count = 0;
           for(int key : map.keySet()){
               if(i <= key) count += map.get(key);
           }
           int failCount = map.getOrDefault(i,0);

           if(count !=0 && failCount != 0) failureRate = (double) failCount/count;

            stage.put("stage", (double) i);
            stage.put("failureRate",failureRate);
            list.add(stage);
        }
        Collections.sort(list,(a,b) ->  
                         b.get("failureRate").compareTo(a.get("failureRate")) );

        for(int i=0; i< list.size(); i++) {
            answer[i] = list.get(i).get("stage").intValue();
        }
        
        return answer;
    }
}