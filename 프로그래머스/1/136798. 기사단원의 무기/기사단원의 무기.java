class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 1번 기사부터 number번 기사까지 순회
        for(int i=1; i<=number; i++){
            
            // i의 약수 개수를 저장할 변수
            int cnt = 0;
            
            // 약수는 i의 제곱근까지만 검사
            // (약수는 항상 쌍으로 존재하기 때문)
            for(int j=1; j*j <= i; j++){
                
                // j*j == i 인 경우 (예: 4 -> 2*2)
                // 같은 약수가 중복되므로 1개만 증가
                if(j*j == i) cnt++;
                
                // i가 j로 나누어 떨어지는 경우
                // j와 i/j 두 개의 약수가 생김
                else if(i%j == 0) cnt+=2;
            }
            
            // 약수 개수가 limit보다 크면
            // 해당 기사는 power 만큼의 공격력만 사용
            if(cnt>limit) cnt = power;
            
            // 모든 기사 공격력을 합산
            answer+= cnt;
        }
        
        // 최종 필요한 철의 무게 반환
        return answer;
    }
}