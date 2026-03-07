class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 0; // 페인트를 칠한 횟수
        int tmp = 0;    // 현재 롤러로 칠해진 마지막 위치
        
        // 칠해야 할 구역을 순서대로 확인
        for(int i = 0; i < section.length; i++){
            
            // 이미 이전 롤러로 칠해진 구역이라면 건너뜀
            if(tmp > section[i]) 
                continue;
            
            else{
                /*
                 새로운 롤러 사용
                 
                 section[i] 위치부터 시작해서
                 길이 m 만큼 칠해짐
                */
                tmp = section[i] + m;
                
                // 롤러 사용 횟수 증가
                answer++;
            }
        }
        
        return answer;
    }
}