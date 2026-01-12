class Solution {
    public int[] solution(long begin, long end) {
        
        // begin부터 end까지의 숫자 개수
        int size = (int) (end - begin) + 1;
        int[] answer = new int[size];

        // begin ~ end 범위의 각 숫자에 대해 블록 번호 계산
        for(long i=begin; i<=end; i++) {
            // i - begin : answer 배열의 인덱스
            answer[(int) (i-begin)] = getBlock((int)i);
        }
        
        return answer;
    }
    
    int getBlock(int i) {
        
        // 문제 조건: 숫자 1의 블록 값은 0
        if(i == 1) return 0;
        
        // 기본값은 1 (어떤 수든 1은 약수이므로)
        int result = 1;

        // 2부터 √i 까지 약수 탐색
        for(int j=2; j*j<=i; j++) {
            
            // j가 i의 약수인 경우
            if(i%j == 0) {
                
                // i / j는 j와 짝을 이루는 큰 약수
                // 블록 번호는 10,000,000 이하만 가능
                if (i/j <= 10000000) {
                    //i가 제일 작은 약수이면 i/j는 제일 큰 약수임 따라서 반복문 종료
                    result = i/j;
                    break;
                    
                } else {
                    // 큰 약수가 범위를 초과하면
                    // 현재 약수 j를 후보로 저장하고 계속 탐색
                    result = j;
                }
            }
        }

        return result;
    }
    
}