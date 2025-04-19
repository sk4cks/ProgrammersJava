class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int num = 1;
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int temp = matrix[x1][y2];
            int min = temp;

            for(int j=y2-1; j>=y1; j--) {
                matrix[x1][j+1] = matrix[x1][j];
                min = Math.min(min,matrix[x1][j]);
            }

            for(int j=x1+1; j<=x2; j++) {
                matrix[j-1][y1] = matrix[j][y1];
                min = Math.min(min,matrix[j][y1]);
            }

            for(int j=y1+1; j<=y2; j++) {
                matrix[x2][j-1] = matrix[x2][j];
                min = Math.min(min,matrix[x2][j]);
            }

            for(int j=x2-1; j>x1; j--) {
                matrix[j+1][y2] = matrix[j][y2];
                min = Math.min(min,matrix[j][y2]);
            }

            matrix[x1+1][y2] = temp;
            answer[i] = min;
        }
        
        return answer;
    }
}