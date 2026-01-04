class Solution {
    public int solution(String s) {
         int answer = s.length();   // 압축하지 않았을 때의 길이를 기본값으로 설정
        
        // 자를 단위 길이: 1 ~ 문자열 길이의 절반까지
        for(int i=1; i<=s.length()/2; i++){
            String base = s.substring(0,i); // 기준이 되는 문자열 (비교 대상)
            int count = 1;  // base가 연속으로 나온 횟수
            String result = ""; // 현재 단위(i)로 압축한 결과 문자열
            
            // i 단위로 문자열을 순회
            for(int j=i; j<=s.length(); j+=i) {
                int endIndex = Math.min(s.length(),j+i);    // 다음 비교 문자열의 끝 인덱스 보정
                String cur = s.substring(j,endIndex);       // 현재 비교할 문자열
                
                // 이전 문자열과 같으면 카운트 증가
                if (base.equals(cur)) count++;
                
                // 다른 문자열이 나오면 지금까지의 결과 반영
                else {
                    if(count > 1 ) result += count; // 반복 횟수가 2 이상일 경우 숫자 추가
                    result += base; // 기준 문자열 추가
                    base = cur;     // 새로운 기준 문자열로 갱신
                    count = 1;
                }
            }
            
            result += base; // 마지막 남은 문자열 처리
            answer = Math.min(answer,result.length());  // 최소 길이 갱신
        }
        
        return answer;  // 가장 짧게 압축된 길이 반환
    }
}