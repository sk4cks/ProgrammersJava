class Solution {
    public int solution(String t, String p) {
        
        // p를 숫자로 변환 (비교 기준)
        long pValue = Long.valueOf(p);
        
        // 조건을 만족하는 부분 문자열 개수
        int answer = 0;

        // t에서 p 길이만큼 잘라가며 탐색
        // (끝 인덱스 주의: p.length()만큼 남아 있어야 함)
        for(int i=0; i<t.length() - p.length() + 1; i++){
            
            // 현재 위치에서 p 길이만큼 부분 문자열 추출
            String tmp = t.substring(i, i + p.length());
            
            // 문자열을 숫자로 변환 후 비교
            // tmp <= p 이면 카운트 증가
            if(Long.valueOf(tmp) <= pValue) 
                answer++;
        }
        
        // 결과 반환
        return answer;
    }
}