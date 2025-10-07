import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0; // 건전지를 사용한 횟수 (= 점프 횟수)
        
        // n이 0이 될 때까지 반복
        while (n>0){
            // n을 2로 나눴을 때 나머지가 1이라면,
            // 즉 현재 수가 홀수라면, 점프해야 함 → 건전지 1 사용
            if(n%2==1) answer++;
            
            // n을 2로 나눠 다음 단계로 이동 (순간이동 or 점프 후 절반 줄이기)
            n /= 2;
        }

        // 전체 점프 횟수 반환
        return answer;
    }
}