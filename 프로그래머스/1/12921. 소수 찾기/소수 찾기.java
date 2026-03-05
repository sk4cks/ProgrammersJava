class Solution {
    public int solution(int n) {
        int answer = 0;  // 소수의 개수를 저장할 변수
        
        /*
         2부터 n까지 모든 숫자를 검사
         1은 소수가 아니므로 2부터 시작
        */
        for(int i = 2; i <= n; i++) {
            
            // i가 소수이면 개수 증가
            if(isPrime(i)) 
                answer++;
        }
        
        return answer;
    }
    
    /*
     주어진 숫자가 소수인지 판별하는 함수
    */
    boolean isPrime(int n) {
        
        /*
         2부터 √n까지만 검사
         이유:
         약수는 항상 √n을 기준으로 쌍으로 존재하기 때문
         → √n보다 큰 약수를 확인할 필요 없음
        */
        for(int i = 2; i <= Math.sqrt(n); i++) {
            
            // 나누어 떨어지면 소수가 아님
            if(n % i == 0) 
                return false;
        }
        
        // 끝까지 나누어 떨어지지 않으면 소수
        return true;
    }
}