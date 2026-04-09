class Solution {
    public int solution(int[] a, int[] b) {
        
        // 결과값 (두 벡터의 내적)
        int answer = 0;
        
        // 배열을 순회하면서 같은 인덱스끼리 곱함
        for(int i=0; i<a.length; i++) {
            
            // a[i] * b[i] 값을 누적
            answer += a[i] * b[i];
        }
        
        // 최종 내적 결과 반환
        return answer;
    }
}