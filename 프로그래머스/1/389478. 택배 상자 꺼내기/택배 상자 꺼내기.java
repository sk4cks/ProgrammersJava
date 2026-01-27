class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        // 전체 박스를 담을 2차원 배열
        // 행 개수 = 필요한 줄 수 = ceil(n / w)
        int[][] boxes = new int[(n + w - 1) / w][w];

        int startNum = 1;          // 박스 번호 (1번부터 n번까지)
        int[] targetArr = new int[2]; // 찾고자 하는 num의 위치 (행, 열)

        // 1. 지그재그 형태로 박스 채우기
        for (int i = 0; i < boxes.length; i++) {

            // 짝수 행: 왼쪽 → 오른쪽
            if (i % 2 == 0) {
                for (int j = 0; j < w && startNum <= n; j++) {

                    // num의 위치 기억
                    if (startNum == num) {
                        targetArr = new int[]{i, j};
                    }

                    boxes[i][j] = startNum++;
                }

            // 홀수 행: 오른쪽 → 왼쪽
            } else {
                for (int j = w - 1; j >= 0 && startNum <= n; j--) {

                    // num의 위치 기억
                    if (startNum == num) {
                        targetArr = new int[]{i, j};
                    }

                    boxes[i][j] = startNum++;
                }
            }
        }

        // 2. num이 있는 위치의 "같은 열"에서
        //    맨 위까지 몇 개의 박스가 있는지 계산
        for (int i = boxes.length - 1; i >= targetArr[0]; i--) {
            if (boxes[i][targetArr[1]] > 0) {
                answer++;
            }
        }

        return answer;
    }
}