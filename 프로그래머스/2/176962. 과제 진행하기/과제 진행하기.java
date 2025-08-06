import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Stack<String[]> stack = new Stack<>();
        int answerIndex = 0;
        
        Arrays.sort(plans, Comparator.comparing(a -> a[1]));
        LocalTime curTime = LocalTime.parse(plans[0][1],formatter);

        for(int i=0; i<plans.length-1; i++) {
            LocalTime prevTime = LocalTime.parse(plans[i][1],formatter);
            LocalTime nextTime = LocalTime.parse(plans[i+1][1],formatter);

            long diff = ChronoUnit.MINUTES.between(prevTime,nextTime);
            long time = Long.parseLong(plans[i][2]);

            if(diff < time) {
                long remain = time - diff;
                stack.push(new String[]{plans[i][0],String.valueOf(remain)});
                curTime = ChronoUnit.MINUTES.addTo(curTime,diff);
            }else{
                answer[answerIndex++] = plans[i][0];
                curTime = ChronoUnit.MINUTES.addTo(curTime,time);

                long nextRemain = ChronoUnit.MINUTES.between(curTime,nextTime);

                while (nextRemain > 0 && !stack.isEmpty()) {
                    String[] prevPlan = stack.pop();
                    long prevRemain = Long.parseLong(prevPlan[1]);
                    nextRemain -= prevRemain;
                    if(nextRemain < 0) {
                        stack.push(new String[]{prevPlan[0],String.valueOf(-nextRemain)});
                    }else{
                        answer[answerIndex++] = prevPlan[0];
                    }
                }
                curTime = nextTime;
            }
        }

        answer[answerIndex++] = plans[plans.length-1][0];

        while (!stack.isEmpty()) {
            answer[answerIndex++] = stack.pop()[0];
        }
        
        return answer;
    }
}