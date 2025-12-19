class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int num = 1;
        int[][] matrix = new int[rows][columns];    // rows x columns 크기의 행렬 생성
        int[] answer = new int[queries.length];     // 각 쿼리마다 회전 후 최솟값을 담을 배열

        // 1부터 rows*columns까지 행렬에 순서대로 값 채우기
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        // 각 회전 쿼리 처리
        for(int i=0; i<queries.length; i++) {
            
            // 쿼리는 1-based index이므로 0-based로 변환
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            int temp = matrix[x1][y2];  // 회전 시작을 위해 오른쪽 위 값을 임시 저장
            int min = temp;             // 회전 중 만나는 값들 중 최솟값 추적

            // ① 위쪽 행 (오른쪽 → 왼쪽 이동)
            for(int j=y2-1; j>=y1; j--) {
                matrix[x1][j+1] = matrix[x1][j];
                min = Math.min(min,matrix[x1][j]);
            }

            // ② 왼쪽 열 (위 → 아래 이동)
            for(int j=x1+1; j<=x2; j++) {
                matrix[j-1][y1] = matrix[j][y1];
                min = Math.min(min,matrix[j][y1]);
            }

            // ③ 아래쪽 행 (왼쪽 → 오른쪽 이동)
            for(int j=y1+1; j<=y2; j++) {
                matrix[x2][j-1] = matrix[x2][j];
                min = Math.min(min,matrix[x2][j]);
            }

            // ④ 오른쪽 열 (아래 → 위 이동)
            for(int j=x2-1; j>x1; j--) {
                matrix[j+1][y2] = matrix[j][y2];
                min = Math.min(min,matrix[j][y2]);
            }

            matrix[x1+1][y2] = temp;    // 처음 저장해 둔 값을 회전된 위치에 삽입
            answer[i] = min;            // 해당 쿼리의 최소값 저장
        }
        
        // 모든 쿼리 결과 반환
        return answer;
    }
}