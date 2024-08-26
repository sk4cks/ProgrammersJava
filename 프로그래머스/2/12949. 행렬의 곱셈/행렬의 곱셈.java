class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int col = arr2[0].length;
        int[][] answer = new int[arr1.length][col];

        for(int i=0; i<arr1.length; i++){
            for(int k=0; k<col; k++){
                int value = 0;
                for(int l=0; l<arr2.length; l++){
                    value += arr1[i][l] * arr2[l][k];
                }
                answer[i][k] = value;
            }
        }
        return answer;
    }
}