class Solution {
    public String solution(int[] food) {
        
        // 왼쪽 절반 문자열을 만들 변수
        String answer = "";
        
        // food[0]은 물(중앙)이라 제외하고 1번 음식부터 시작
        for(int i=1; i<food.length; i++){
            
            // 각 음식은 절반씩 나눠서 양쪽에 배치
            int count = food[i] / 2;
            
            // 배치할 수 있는 개수가 있으면
            if(count > 0){
                for(int j=0; j<count; j++){
                    
                    // 왼쪽 절반에 음식 번호 추가
                    answer += i;
                }
            }
        }
        
        // 오른쪽 절반을 만들기 위해 문자열 뒤집기
        StringBuffer str = new StringBuffer(answer);
        
        // 최종 구조
        // 왼쪽 + "0"(물) + 오른쪽(왼쪽 뒤집기)
        return answer + "0" + str.reverse().toString();
    }
}