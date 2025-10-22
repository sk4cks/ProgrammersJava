import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 1️⃣ 인용 횟수 배열을 오름차순 정렬
        Arrays.sort(citations);

        // 2️⃣ 각 논문을 기준으로 H-Index 계산 시도
        // citations[i] : i번째 논문의 인용 횟수
        // citations.length - i : 인용 횟수가 citations[i] 이상인 논문의 개수
        for(int i=0; i<citations.length; i++){
            
            // 만약 현재 논문의 인용 수가 (현재보다 인용 횟수가 크거나 같은 논문 수) 이상이라면,
            // 그 수가 H-Index 조건을 만족함.
            if(citations[i]>=citations.length-i){
                answer = citations.length-i;
                break;  // 조건을 처음 만족하는 시점이 최대 H-Index이므로 종료
            }
        }
        
        // 3️⃣ 계산된 H-Index 반환
        return answer;
    }
}