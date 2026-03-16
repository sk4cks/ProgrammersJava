class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        // 결과로 반환할 지도 배열
        String[] answer = new String[n];

        // n개의 행을 순회하면서 지도 생성
        for(int i=0; i<n; i++){
            
            // arr1[i]와 arr2[i]를 비트 OR 연산으로 합침
            // 두 값 중 하나라도 1이면 결과는 1
            int combined = arr1[i] | arr2[i];

            // OR 연산 결과를 2진수 문자열로 변환
            // ex) 9 -> "1001"
            // String.format("%ns") : 전체 길이를 n으로 맞추고 왼쪽을 공백으로 채움
            // replace(' ', '0') : 공백을 0으로 바꿔서 n자리 2진수 완성
            String str = String.format("%" + n + "s",
                         Integer.toBinaryString(combined))
                         .replace(' ', '0');

            // 2진수 지도 변환
            // 1 -> 벽(#)
            // 0 -> 빈 공간(공백)
            str = str.replace('1','#').replace('0',' ');

            // 완성된 한 줄을 결과 배열에 저장
            answer[i] = str;
        }

        // 완성된 지도 배열 반환
        return answer;
    }
}