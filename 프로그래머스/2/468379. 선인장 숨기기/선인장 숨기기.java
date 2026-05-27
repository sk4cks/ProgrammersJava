import java.util.Arrays;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = {0 ,0};
        int[][] wetSecondArr = new int[m][n]; // 젖는 초 배열

        // 젖는 초 배열 안젖는초로 먼저 초기화
        // ex) [1,2]영역이 안젖는 영역이면 1,2의 값은 drops.length
        for (int[] wetSecond : wetSecondArr) {
            Arrays.fill(wetSecond, drops.length);
        }

        // ex) 5초에 [1,1]이 젖으면 wetSecondArr[1,1]의 값은 5
        for (int i=0; i<drops.length; i++) {
            int[] drop = drops[i];
            int x = drop[0];
            int y = drop[1];

            if (wetSecondArr[x][y] == drops.length) {
                wetSecondArr[x][y] = i;
            }
        }

        int left = 0;
        int right = drops.length;

        // 젖는 초 기준 이분탐색
        while (left <= right) {
            int mid = (left + right) / 2;

            // 젖는 초 기준 선인장영역 찾기
            int[] safeZone = findSafeZone(m, n, h, w, wetSecondArr, mid);

            // 안젖는 선인장 영역이 있으면 시간초를 더 늦출수 있는지 확인
            if (safeZone != null) {
                left = mid + 1;
                answer = safeZone;
                
            // 안젖는 선인장 영역이 없으면 시간초을 앞당겨서 확인
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
    
    // 안젖는 선인장 영역 찾기
    public int[] findSafeZone(int m, int n, int h, int w, int[][] wetSecondArr, int mid) {
        int[][] subSumArr = new int[m+1][n+1]; // 왼쪽 위 사각형 누적합 배열 (pSum[i+1][j+1] = val[0~i][0~j] 합)

        // 왼쪽 위 
        for (int x=0; x<m; x++) {
            for (int y=0; y<n; y++) {
                // 초 기준 젖어있으면 1 아니면 0
                int wetVal = wetSecondArr[x][y] < mid ? 1 : 0;

                // 현재 칸 = val + 위쪽 누적 + 왼쪽 누적 - 겹친 모서리
                subSumArr[x+1][y+1] = wetVal + subSumArr[x+1][y] + subSumArr[x][y+1] - subSumArr[x][y];
            }
        }

        for (int i=h; i<=m; i++) {
            for (int j=w; j<=n; j++) {
                // subSumArr 네 꼭짓점으로 가운데 h×w 합 계산 (O(1))
                //
                //   ①(i-h,j-w) ─── ③(i-h,j)
                //        │    h×w     │
                //   ②(i,j-w)   ───   ④(i,j)
                //
                // ① subSumArr[i-h][j-w]  → + (겹친 모서리, 두 번 뺀 만큼 복구)
                // ② subSumArr[i][j-w]    → - (왼쪽 띠)
                // ③ subSumArr[i-h][j]    → - (위쪽 띠)
                // ④ subSumArr[i][j]      → + (전체, h×w + 바깥 래퍼 포함)
                //
                // sum = ④ - ③ - ② + ①
                int sum = subSumArr[i][j] - subSumArr[i-h][j] - subSumArr[i][j-w] + subSumArr[i-h][j-w];

                if (sum == 0) {
                    return new int[]{i-h, j-w};
                }
            }
        }

        return null;
    }

}