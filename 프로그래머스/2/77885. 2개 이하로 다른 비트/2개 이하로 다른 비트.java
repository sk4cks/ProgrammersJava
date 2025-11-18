class Solution {
    public long[] solution(long[] numbers) {
        // 원본 배열을 복사해서 답을 저장할 배열 생성 (원본 보존을 위해 clone)
        long[] answer = numbers.clone();
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++;    // ① 현재 숫자에 1을 더한다
            
            // ② (answer[i] ^ numbers[i])
            //    → 원래 숫자와 +1 한 숫자를 XOR 연산
            //      달라진 비트 위치들이 1로 표시됨
            //    → 그 결과를 >> 2 (오른쪽으로 2비트 시프트)
            //      가장 낮은 비트에서 연속된 0의 개수와 관련된 정보를 추출
            //    → 이 값을 다시 더해줌
            //      끝자리가 111...1 인 경우에 필요한 보정값이 됨
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        
        return answer;
    }
}