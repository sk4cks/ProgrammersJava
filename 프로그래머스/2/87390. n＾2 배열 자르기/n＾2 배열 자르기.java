class Solution {
    public int[] solution(int n, long left, long right) {
        int index = 0;  // answer 배열에 값을 채워넣을 위치 인덱스
        int[] answer = new int[(int) (right-left+1)];   // left~right 구간 길이만큼 결과 배열 생성

        // 1차원 인덱스 i를 2차원 (row, col) 좌표로 변환하여 해당 위치의 값을 계산
        for(long i=left; i<=right; i++){
            long col = i%n; // 열 인덱스 (나머지)
            long row = i/n; // 행 인덱스 (몫)

            // n×n 배열의 규칙:
            // arr[row][col] = max(row, col) + 1
            // 예시: n=3일 때
            // 1 2 3
            // 2 2 3
            // 3 3 3
            answer[index++] = (int) (Math.max(row, col) + 1);
        }
        
        return answer;
    }
}