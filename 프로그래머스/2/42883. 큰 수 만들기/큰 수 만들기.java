class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(); // 최종 결과 숫자를 만들 StringBuilder
        char[] arr = number.toCharArray();      // 문자열을 문자 배열로 변환
        int index = 0;                          // 현재 탐색을 시작할 인덱스
        char max = 0;                           // 현재 구간에서 선택된 최대 숫자

        // number.length() - k 길이만큼 숫자를 만들어야 함
        for(int i=0; i<arr.length-k; i++) {
            max = 0;
            
            // 현재 위치 i에서 선택할 숫자는
            // index ~ i + k 범위 안에서 가장 큰 값이어야 함
            for(int j=index; j<=i+k; j++) {
                
                // 현재 범위에서 가장 큰 숫자를 찾는다
                if(arr[j] > max) {
                    max = arr[j];
                    index = j+1;    // 다음 탐색 구간은 max 다음 위치부터 시작
                }
                
                // 9는 최대값이므로 더 볼 필요 없음 (가지치기)
                if(max==9) break;
            }
            
            // 가장 큰 숫자를 결과에 추가
            sb.append(max);
        }
        
        return sb.toString();
    }
}