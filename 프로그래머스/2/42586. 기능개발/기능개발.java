import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();     // 각 기능이 완료되기까지 걸리는 '일수'를 저장할 리스트
        List<Integer> answer = new ArrayList<>();   // 최종 배포 단위별로 몇 개의 기능이 포함되는지를 저장할 리스트 (정답)
        int count = 1;  // 같은 배포에 포함되는 기능 개수를 세는 변수

        // 1️⃣ 각 기능별로 완료까지 걸리는 일수 계산
        for(int i=0; i< progresses.length; i++){
           int remainingProgress  = 100-progresses[i];  // 남은 진도율
           int day = remainingProgress/speeds[i];       // 하루에 진행하는 속도로 나눈 일수
           if(remainingProgress%speeds[i] > 0) day+=1;  // 나머지가 있으면 하루 더 필요
            days.add(day);  // 기능별 완료일수 저장
        }

        // 2️⃣ 첫 번째 기능을 기준으로 배포 그룹 묶기
        int minDay = days.get(0);   // 첫 기능이 완료되는 일수
        for(int i=1; i< days.size(); i++){
            
            // 현재 기능이 이전 기능보다 빨리(또는 같은 날에) 끝난다면 같은 배포로 묶음
            if(minDay >= days.get(i)){
                count++;
                
            // 현재 기능이 더 늦게 끝난다면 새로운 배포 시작
            }else{
                answer.add(count);      // 지금까지의 묶음 개수를 추가
                minDay = days.get(i);   // 기준 일수를 갱신
                count = 1;              // 새로운 배포 묶음 시작
            }
        }
        
        // 마지막 배포 그룹 추가
        answer.add(count);

        return answer;
    }
}