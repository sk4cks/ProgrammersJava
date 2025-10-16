class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int col = arr2[0].length;
        
        // 결과를 담을 배열 (행: arr1의 행, 열: arr2의 열)
        int[][] answer = new int[arr1.length][col];

        // arr1의 각 행(i) 반복
        for(int i=0; i<arr1.length; i++){
            
            // arr2의 각 열(k) 반복
            for(int k=0; k<col; k++){
                int value = 0;  // (i행, k열)의 계산 결과를 담을 임시 변수
                
                // arr1의 i번째 행과 arr2의 k번째 열을 곱해서 모두 더함
                for(int l=0; l<arr2.length; l++){
                    value += arr1[i][l] * arr2[l][k];
                }
                
                // 계산된 값을 결과 행렬에 저장
                answer[i][k] = value;
            }
        }
        return answer;
    }
}