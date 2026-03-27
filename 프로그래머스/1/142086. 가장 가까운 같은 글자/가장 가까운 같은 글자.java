class Solution {
    public int[] solution(String s) {
        
        // 각 위치에서 가장 가까운 같은 문자까지의 거리를 저장할 배열
        int[] answer = new int[s.length()];
        
        // 문자열을 한 글자씩 분리 (문자 배열처럼 사용)
        String[] splitString = s.split("");
        
        // 첫 번째 문자는 이전에 같은 문자가 없으므로 -1
        answer[0] = -1;

        // 두 번째 문자부터 순회
        for(int i=1; i< splitString.length; i++){
            
            // 기본값은 -1 (같은 문자가 없을 경우)
            answer[i] = -1;
            
            // 현재 위치 i에서 왼쪽으로 탐색 (가장 가까운 문자 찾기)
            for(int j= i-1; j>=0; j--){
                
                // 같은 문자를 찾으면
                if(splitString[i].equals(splitString[j])){
                    
                    // 현재 위치 - 찾은 위치 = 거리
                    answer[i] = i - j;
                    
                    // 가장 가까운 하나만 찾으면 되므로 종료
                    break;
                }
            }
        }
        
        // 결과 반환
        return answer;
    }
}