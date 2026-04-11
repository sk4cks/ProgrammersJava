class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        
        // 최종 합을 저장할 변수
        int answer = 0;

        // 배열을 순회하면서 값과 부호를 함께 처리
        for(int i=0; i<absolutes.length; i++){
            
            // signs[i]가 true면 양수, false면 음수
            // true  → +absolutes[i]
            // false → -absolutes[i]
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        
        // 최종 결과 반환
        return answer;
    }
}