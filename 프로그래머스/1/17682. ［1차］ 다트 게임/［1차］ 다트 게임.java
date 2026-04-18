import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        // 각 라운드(총 3번)의 점수를 저장할 배열
        int[] arr = new int[3];
        
        // 숫자를 임시로 저장할 문자열 (10 같은 두 자리 숫자 처리용)
        String temp = "";
        
        // 현재 몇 번째 라운드인지 가리키는 인덱스
        int idx = 0;

        // 문자열을 한 글자씩 순회
        for(int i=0; i<dartResult.length(); i++){
            char word = dartResult.charAt(i);

            // [옵션] 아차상 (#) → 해당 라운드 점수를 음수로 변경
            if(word == '#') {
                arr[idx-1] *= -1;
            }
            
            // [옵션] 스타상 (*) 
            // 현재 점수와 이전 점수를 각각 2배로 만듦
            else if(word == '*') {
                for(int j=idx-1; j>=idx-2; j--) {
                    arr[j] *= 2;
                    
                    // 인덱스가 0보다 작아지지 않도록 방지
                    if(j == 0) break;
                }
            }
            
            // [숫자] (0~9)
            // 숫자를 이어붙여서 저장 (예: '1' 다음 '0' → "10")
            else if(48 <= word && word <= 57) {
                temp += dartResult.charAt(i);
            }
            
            // [보너스] S, D, T 처리
            else {
                int pow = 1;
                
                // D = 2제곱
                if(word == 'D') pow = 2;
                // T = 3제곱
                else if(word == 'T') pow = 3;
                // S는 기본값 1제곱

                // temp에 저장된 숫자를 제곱하여 현재 라운드 점수로 저장
                arr[idx++] = (int) Math.pow(Integer.parseInt(temp), pow);
                
                // 다음 숫자를 위해 temp 초기화
                temp = "";
            }
        }

        // 모든 라운드 점수 합산
        answer = Arrays.stream(arr).sum();
        return answer;
    }
}