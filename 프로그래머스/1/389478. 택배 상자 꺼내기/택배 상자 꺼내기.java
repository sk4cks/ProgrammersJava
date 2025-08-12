class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] boxes = new int[(n + w - 1) / w][w];
        int startNum = 1;
        int[] targetArr = new int[2];
        
        for(int i=0; i<boxes.length; i++) {
            if(i%2 == 0) {
                for(int j=0; j<w &&  startNum <= n ; j++) {
                    if(startNum == num) {
                        targetArr = new int[]{i,j};
                    }
                    boxes[i][j] = startNum++;
                }
            }else{
                for(int j=w-1; j>=0 && n >= startNum; j--) {
                    if(startNum == num) {
                        targetArr = new int[]{i,j};
                    }
                    boxes[i][j] = startNum++;
                }
            }
        }
        
        for(int i=boxes.length-1; i>=targetArr[0]; i--) {
            if(boxes[i][targetArr[1]] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}