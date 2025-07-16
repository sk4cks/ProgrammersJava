class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] boxes = new int[(n+w-1)/w][w];
        int startNum = 1;
        int[] startArr = new int[2];
        int[] targetArr = new int[2];
        
        Loop:
        while (startNum <= n) {
            for(int i=0; i<w; i++) {
                if(startNum == num) {
                    targetArr = new int[]{startArr[0],startArr[1]};
                }
                boxes[startArr[0]][startArr[1]++] = startNum++;
                if(startNum > n) break Loop;
            }
            startArr[0]++;
            startArr[1]--;

            for(int i=w-1; i>=0; i--) {
                if(startNum == num) {
                    targetArr = new int[]{startArr[0],startArr[1]};
                }
                boxes[startArr[0]][startArr[1]--] = startNum++;
                if(startNum > n) break Loop;
            }
            startArr[0]++;
            startArr[1]++;
        }
        
        for(int i=boxes.length-1; i>=targetArr[0]; i--) {
            if(boxes[i][targetArr[1]] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}