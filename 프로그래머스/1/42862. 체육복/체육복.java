import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 처음에는 전체 학생 수에서 도난당한 학생 수를 뺀 값이
        // 체육복을 가진 학생 수
        int answer = n - lost.length;
        
        // 탐색을 쉽게 하기 위해 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        /*
         1단계
         여벌 체육복이 있지만 동시에 도난당한 학생 처리
         → 자기 체육복을 사용하면 되므로 정상 상태가 됨
        */
        for(int i=0; i<lost.length; i++){
            for(int j=0; j< reserve.length; j++){
                if(reserve[j] == lost[i]){
                    
                    // 이미 처리된 학생 표시
                    reserve[j] = -1;
                    lost[i] = -1;
                    
                    // 체육복을 입을 수 있는 학생 증가
                    answer++;
                    break;
                }
            }
        }
        
        /*
         2단계
         아직 체육복이 없는 학생에게
         앞번호 또는 뒷번호 학생이 빌려줌
        */
        for(int i=0; i<lost.length; i++){
            
            // 이미 해결된 학생은 건너뜀
            if(lost[i] == -1) continue;
            
            for(int j=0; j< reserve.length; j++){
                
                // 번호 차이가 1이면 빌려줄 수 있음
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