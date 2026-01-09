import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        // 완료된 과제 이름을 담을 결과 배열
        String[] answer = new String[plans.length];
        
        // "HH:mm" 형식의 시간을 파싱하기 위한 포맷터
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        // 중단된 과제를 저장하는 스택 (과제명, 남은 시간)
        Stack<String[]> stack = new Stack<>();
        
        // answer 배열에 값을 채우기 위한 인덱스
        int answerIndex = 0;
        
        // 시작 시간을 기준으로 과제 정렬
        Arrays.sort(plans, Comparator.comparing(a -> a[1]));
        
        // 현재 시간 (첫 번째 과제 시작 시간)
        LocalTime curTime = LocalTime.parse(plans[0][1],formatter);

        // 마지막 과제를 제외한 모든 과제 처리
        for(int i=0; i<plans.length-1; i++) {
            
            // 현재 과제 시작 시간
            LocalTime prevTime = LocalTime.parse(plans[i][1],formatter);
            // 다음 과제 시작 시간
            LocalTime nextTime = LocalTime.parse(plans[i+1][1],formatter);

            // 두 과제 시작 시간 사이의 간격(분)
            long diff = ChronoUnit.MINUTES.between(prevTime,nextTime);
            // 현재 과제 소요 시간
            long time = Long.parseLong(plans[i][2]);

            // 다음 과제 시작 전까지 현재 과제를 끝내지 못하는 경우
            if (diff < time) {
                // 남은 시간 계산
                long remain = time - diff;
                // 현재 과제를 스택에 저장 (중단)
                stack.push(new String[]{plans[i][0],String.valueOf(remain)});
                // 현재 시간을 diff 만큼 진행
                curTime = ChronoUnit.MINUTES.addTo(curTime,diff);
                
            // 현재 과제를 정상적으로 완료한 경우
            } else {
                answer[answerIndex++] = plans[i][0];
                // 현재 시간을 과제 소요 시간만큼 증가
                curTime = ChronoUnit.MINUTES.addTo(curTime,time);

                // 다음 과제 시작까지 남은 시간
                long nextRemain = ChronoUnit.MINUTES.between(curTime,nextTime);

                // 남은 시간 동안 스택에 쌓인 중단 과제 처리
                while (nextRemain > 0 && !stack.isEmpty()) {
                    String[] prevPlan = stack.pop();
                    long prevRemain = Long.parseLong(prevPlan[1]);
                    nextRemain -= prevRemain;
                    
                    // 중단 과제를 다 끝내지 못한 경우 다시 스택에 저장
                    if (nextRemain < 0) {
                        stack.push(new String[]{prevPlan[0],String.valueOf(-nextRemain)});
                        
                    // 중단 과제를 모두 완료한 경우
                    } else {
                        answer[answerIndex++] = prevPlan[0];
                    }
                }
                
                // 현재 시간을 다음 과제 시작 시간으로 맞춤
                curTime = nextTime;
            }
        }

        // 마지막 과제는 무조건 완료
        answer[answerIndex++] = plans[plans.length-1][0];

        // 스택에 남아 있는 중단 과제들을 순서대로 완료
        while (!stack.isEmpty()) {
            answer[answerIndex++] = stack.pop()[0];
        }
        
        return answer;
    }
}