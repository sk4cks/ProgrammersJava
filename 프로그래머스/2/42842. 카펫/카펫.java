import java.util.HashMap;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];  // [가로, 세로] 결과를 담을 배열
        int area = brown+yellow;    // 전체 격자(카펫)의 넓이
        
        // 1️⃣ 가능한 세로 길이(i)를 3부터 탐색 (세로 최소 길이는 3)
        for(int i=3; i<=area; i++){
            int quotient = area/i;  // 가로 길이 후보 (나눈 몫)
            
            // 2️⃣ 전체 넓이가 나누어떨어지고, 가로 세로 모두 3 이상일 때만 검사
            if(area%i==0 && quotient > 2){
                int width = Math.max(i,quotient);   // 가로는 더 큰 값
                int height = Math.min(i,quotient);  // 세로는 더 작은 값

                // 3️⃣ 노란색(내부) 격자 수가 일치하는지 검사
                //    전체에서 테두리(1칸씩 제외한 부분)의 넓이가 yellow와 같아야 함
                if(yellow == (width-2) * (height-2)){
                    answer[0] = width;  // 가로 길이 저장
                    answer[1] = height; // 세로 길이 저장
                    break;              // 정답을 찾았으므로 종료
                }
            }
        }
        
        return answer;
    }
    
    
}