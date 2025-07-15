class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            answer++;
            schedules[i] += 10;
            if(schedules[i] % 100 > 59) {
                schedules[i] += 40;
            }
            for(int j=0; j<timelogs[i].length; j++) {
                if((startday + j-1) % 7 > 4) continue;
                if(schedules[i] < timelogs[i][j]) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}