class Solution {
    public String solution(int n) {
        // 결과를 앞에서부터 붙이기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // n이 0이 될 때까지 반복 (3진법 변환 과정)
        while (n > 0) {
            // n을 3으로 나눈 나머지에 따라 처리
            switch (n%3) {
                    
                // 나머지가 0인 경우
                // 124 나라에서는 0 대신 '4'를 사용
                case 0:
                    sb.insert(0,4);
                    
                    // 몫에서 1을 빼주는 이유:
                    // 124 나라는 일반 3진법과 달리
                    // 0이 없기 때문에 자리 올림 보정이 필요함
                    n = n/3-1;
                    break;
                    
                // 나머지가 1 또는 2인 경우
                // 그대로 앞자리에 추가
                default:
                    sb.insert(0,n%3);
                    
                    // 다음 자리 계산을 위해 3으로 나눔
                    n /= 3;
                    break;
            }
        }
        
        // 완성된 124 나라 숫자 반환
        return sb.toString();
    }
}