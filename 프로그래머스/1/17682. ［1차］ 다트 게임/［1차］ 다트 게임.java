import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        // 각 라운드(총 3번)의 점수를 저장할 배열
        int[] arr = new int[3];
        
        // 숫자를 임시로 저장할 문자열 (10 처리 때문에 필요)
        String temp = "";
        
        // 현재 몇 번째 라운드인지 가리키는 인덱스
        int idx = 0;

        // 문자열을 한 글자씩 순회
        for(int i=0; i<dartResult.length(); i++){
            char word = dartResult.charAt(i);

            // 옵션: 아차상 (#) → 해당 점수 음수 처리
            if(word == '#') {
                arr[idx-1] *= -1;
            }
            
            // 옵션: 스타상 (*) 
            // 현재 점수와 바로 이전 점수를 2배로 만듦
            else if(word == '*') {
                for(int j=idx-1; j>=idx-2; j--) {
                    arr[j] *= 2;
                    
                    // 배열 범위를 벗어나지 않도록
                    if(j == 0) break;
                }
            }
            
            // 숫자인 경우 (0~9)
            // 숫자를 이어붙여서 저장 (10 처리)
            else if(48 <= word && word <= 57) {
                temp += dartResult.charAt(i);
            }
            
            // 보너스 영역 (S, D, T)
            else {
                int pow = 1;
                
                // S = 1제곱
                if(word == 'D') pow = 2;
                // D = 2제곱
                else if(word == 'T') pow = 3;
                // T = 3제곱

                // temp에 저장된 숫자를 제곱 적용 후 저장
                arr[idx++] = (int) Math.pow(Integer.parseInt(temp), pow);
                
                // 다음 숫자를 위해 초기화
                temp = "";
            }
        }

        // 3라운드 점수 합산
        answer = Arrays.stream(arr).sum();
        return answer;
    }
}