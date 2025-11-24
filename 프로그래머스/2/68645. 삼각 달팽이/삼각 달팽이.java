class Solution {
    public int[] solution(int n) {
        // 현재 위치 좌표 초기화 (x, y)
        int x = -1, y = 0;
        
        int start = 0;  // 배열에 넣을 숫자 시작값
        int index = 0;  // 결과 배열 인덱스
        int[][] arr = new int[n][n];    // n x n 2차원 배열 생성 (삼각형 형태 채울 예정)
        int[] answer = new int[n*(n+1) / 2];    // 최종 반환할 1차원 배열 (삼각형 안의 숫자 개수)
        
        // i: 현재 층(step) 길이
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                switch (i%3) {
                    case 1:
                        x++;    // 아래로 이동
                        break;
                    case 2:
                        y++;      // 오른쪽으로 이동
                       break;
                    case 0:
                        x--;     // 대각선 위쪽으로 이동
                        y--;
                        break;
                }
                arr[x][y] = ++start; // 현재 위치에 숫자 채우기
            }
        }
    
        // 2차원 배열에서 0이 아닌 값만 결과 배열에 넣기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0) break;  // 삼각형 모양이므로 0이면 더 이상 채울 값 없음
                answer[index++] = arr[i][j];
            }
        }
        
        // 1차원 배열 반환
        return answer;
    }
}