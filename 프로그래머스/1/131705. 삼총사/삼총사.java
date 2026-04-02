class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        // 서로 다른 세 인덱스 i, j, k를 선택 (i < j < k)
        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k< number.length; k++){
                    
                    // 세 수의 합이 0이면 카운트 증가
                    if(number[i] + number[j] + number[k] == 0) 
                        answer++;
                }
            }
        }
        
        // 조건을 만족하는 조합 개수 반환
        return answer;
    }
}