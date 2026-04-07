class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 결과를 저장할 2차원 배열 생성
        // arr1과 같은 크기로 생성 (행, 열 동일)
        int[][] answer = new int[arr1.length][arr1[0].length];

        // 행(row) 기준 반복
        for(int i=0; i<arr1.length; i++) {
            
            // 열(column) 기준 반복
            for(int j=0; j<arr1[i].length; j++) {
                
                // 같은 위치의 값끼리 더해서 저장
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        // 결과 행렬 반환
        return answer;
    }
}