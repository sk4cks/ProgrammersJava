class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        /*
         1단계
         서로 다른 3개의 숫자 선택
         (조합: i < j < k)
        */
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    
                    // 세 수의 합
                    int total = nums[i] + nums[j] + nums[k];
                    
                    // 합이 소수이면 카운트 증가
                    if(isPrime(total)) 
                        answer++;
                }
            }
        }

        return answer;
    }
    
    /*
     소수 판별 함수
    */
    boolean isPrime(int num) {
        
        // 1 이하 숫자는 소수가 아님
        if(num <= 1) return false;
        
        // 2는 유일한 짝수 소수
        if(num == 2) return true;
        
        // 2를 제외한 짝수는 소수 아님
        if(num % 2 == 0) return false;

        /*
         3부터 √num까지만 검사
         (약수는 √num을 기준으로 쌍으로 존재하기 때문)
         
         i += 2 → 짝수는 이미 걸렀으므로 홀수만 검사
        */
        for(int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0) 
                return false;
        }
        
        return true;
    }
}