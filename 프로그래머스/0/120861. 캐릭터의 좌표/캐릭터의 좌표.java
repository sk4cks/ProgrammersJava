class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int maxX = board[0]/2;
        int maxY = board[1]/2;

        for(int i=0; i<keyinput.length; i++) {
            switch (keyinput[i]) {
                case "up":
                    answer[1] = Math.min(answer[1] + 1, maxY);
                    break;
                case "down":
                    answer[1] = Math.max(answer[1] - 1, -maxY);
                    break;
                case "left":
                    answer[0] = Math.max(answer[0] - 1, -maxX);
                    break;
                case "right":
                    answer[0] = Math.min(answer[0] + 1, maxX);
                    break;
            }
        }
        
        return answer;
    }
}