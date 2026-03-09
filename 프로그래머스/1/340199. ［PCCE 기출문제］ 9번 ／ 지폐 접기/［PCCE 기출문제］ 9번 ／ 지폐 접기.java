import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0; // 지폐를 접은 횟수
        
        // 지갑의 두 변을 오름차순 정렬
        Arrays.sort(wallet);
        
        // 지폐의 두 변도 오름차순 정렬
        Arrays.sort(bill);

        /*
        지폐가 지갑보다 크면 계속 접어야 함
        wallet[0] : 지갑의 짧은 변
        wallet[1] : 지갑의 긴 변
        bill[0]   : 지폐의 짧은 변
        bill[1]   : 지폐의 긴 변
        */
        while (wallet[0] < bill[0] || wallet[1] < bill[1]) {
            
            // 항상 긴 쪽을 반으로 접음
            bill[1] /= 2;
            
            // 접은 후 다시 짧은 변 / 긴 변 정렬
            Arrays.sort(bill);
            
            // 접은 횟수 증가
            answer++;
        }
        
        // 총 접은 횟수 반환
        return answer;
    }
}