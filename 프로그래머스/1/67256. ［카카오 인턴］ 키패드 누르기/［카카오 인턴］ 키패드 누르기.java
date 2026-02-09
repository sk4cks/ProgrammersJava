class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 왼손, 오른손의 현재 위치
        // * = 10, 0 = 11, # = 12 로 가정하여 좌표처럼 사용
        int l = 10, r = 12;
		
        for(int i = 0; i < numbers.length; i++) {
            
            // 0은 계산 편의를 위해 11로 치환
            if(numbers[i] == 0) numbers[i] = 11;
            
            // 1,4,7 (왼쪽 열) → 무조건 왼손
            if(numbers[i] % 3 == 1) {
                answer += "L";
                l = numbers[i];
            
            // 3,6,9 (오른쪽 열) → 무조건 오른손
            } else if(numbers[i] % 3 == 0) {
                answer += "R";
                r = numbers[i];
            
            // 2,5,8,0 (가운데 열) → 거리 비교
            } else if(numbers[i] % 3 == 2) {
                
                // 왼손과 목표 숫자 사이의 거리 계산
                // 세로 이동(÷3) + 가로 이동(%3)
                int ldis = Math.abs(numbers[i] - l) / 3 
                         + Math.abs(numbers[i] - l) % 3;
                
                // 오른손과 목표 숫자 사이의 거리 계산
                int rdis = Math.abs(numbers[i] - r) / 3 
                         + Math.abs(numbers[i] - r) % 3;
				
                // 더 가까운 손 사용
                if(ldis < rdis) {
                    answer += "L";
                    l = numbers[i];
                
                } else if(ldis > rdis) {
                    answer += "R";
                    r = numbers[i];
                
                // 거리가 같으면 주 손(hand) 사용
                } else {
                    if(hand.equals("right")) {
                        answer += "R";
                        r = numbers[i];
                    } else {
                        answer += "L";
                        l = numbers[i];
                    }
                }
            }
        }
        
        return answer;
    }
}