import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int count = 1;


        for(int i=0; i< progresses.length; i++){
           int remainingProgress  = 100-progresses[i];
           int day = remainingProgress/speeds[i];
           if(remainingProgress%speeds[i] > 0) day+=1;
            days.add(day);
        }

        int minDay = days.get(0);
        for(int i=1; i< days.size(); i++){
            if(minDay >= days.get(i)){
                count++;
            }else{
                answer.add(count);
                minDay = days.get(i);
                count = 1;
            }
        }
        answer.add(count);

        return answer;
    }
}