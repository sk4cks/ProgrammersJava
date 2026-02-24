class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        // 결과 배열
        // answer[0] = 최고 순위
        // answer[1] = 최저 순위
        int[] answer = {};
        answer = new int[2];
        
        int count = 0; // 0의 개수 (알 수 없는 숫자)
        int cc = 0;    // 실제로 맞은 숫자 개수
        
        // 로또 번호 확인
        for(int i = 0; i < lottos.length; i++) {
            
            // 0이면 맞을 수도 있는 숫자
            if(lottos[i] == 0) {
                count++;
                continue;
            }
            
            // 당첨 번호와 비교
            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    cc++; // 맞은 숫자 증가
                    break;
                }
            }
        }
        
        /*
         최고 순위 계산
         (맞은 개수 + 0의 개수)가 최대 맞출 수 있는 개수
        */
        if(cc + count >= 2) {
            answer[0] = 7 - (cc + count);
        } else {
            answer[0] = 6; // 맞은 개수가 1개 이하이면 6등
        }
        
        /*
         최저 순위 계산
         실제로 맞은 개수만 사용
        */
        if(cc >= 2) {
            answer[1] = 7 - cc;
        } else {
            answer[1] = 6; // 맞은 개수가 1개 이하이면 6등
        }
        
        // 결과 출력 (디버깅용 코드)
        for(int x : answer)
            System.out.print(x + " ");
        
        return answer;
    }
}