class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 각 직원별로 확인
        for(int i=0; i<schedules.length; i++) {
            
            // 일단 보상 대상이라고 가정하고 +1
            answer++;
            
            // 출근 인정 시간 = 출근 희망 시간 + 10분
            schedules[i] += 10;
            
            // 분이 60 이상이 되는 경우 시간으로 올림 처리
            // 예: 09:58 + 10분 = 09:68 → 10:08 로 변환
            if(schedules[i] % 100 > 59) {
                schedules[i] = ((schedules[i] / 100) + 1) * 100 
                                + ((schedules[i] % 100) - 60);
            }
            
            // 해당 직원의 일주일 출근 기록 확인
            for(int j=0; j<timelogs[i].length; j++) {
                
                // 요일 계산 (startday 기준으로 j일차)
                // 0~4 : 평일, 5~6 : 주말
                if((startday + j - 1) % 7 > 4) continue;
                
                // 평일에 인정 시간보다 늦게 출근한 경우
                if(schedules[i] < timelogs[i][j]) {
                    answer--;  // 보상 대상 제외
                    break;
                }
            }
        }
        
        return answer;
    }
}