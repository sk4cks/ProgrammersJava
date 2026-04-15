import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 기본값: 전체 학생 - 도난당한 학생
        // (일단 잃어버린 학생은 체육복이 없다고 가정)
        int answer = n - lost.length;
        
        // 순서대로 처리하기 위해 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        /*
         1단계: 여벌이 있지만 동시에 도난당한 학생 처리
         → 자기 여벌을 쓰면 되므로 정상 상태
        */
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                
                // 같은 학생 (여벌 + 도난)
                if(reserve[j] == lost[i]){
                    
                    // 사용 처리 (이미 처리된 상태 표시)
                    reserve[j] = -1;
                    lost[i] = -1;
                    
                    // 체육복 입을 수 있는 학생 증가
                    answer++;
                    break;
                }
            }
        }
        
        /*
         2단계: 체육복 없는 학생에게 빌려주기
         → 앞번호 또는 뒷번호 학생만 가능
        */
        for(int i=0; i<lost.length; i++){
            
            // 이미 해결된 학생은 건너뜀
            if(lost[i] == -1) continue;
            
            for(int j=0; j<reserve.length; j++){
                
                // 번호 차이가 1이면 대여 가능
                if(reserve[j] == lost[i] - 1 || 
                   reserve[j] == lost[i] + 1){
                    
                    // 여벌 사용 처리
                    reserve[j] = -1;
                    
                    // 체육복 입을 수 있는 학생 증가
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}