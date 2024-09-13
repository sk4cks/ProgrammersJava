class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] rectangle = new int[2];

        for(int i=0; i<sizes.length; i++){
            int width = Math.max(sizes[i][0],sizes[i][1]);
            int height = Math.min(sizes[i][0],sizes[i][1]);

            rectangle[0] = Math.max(width,rectangle[0]);
            rectangle[1] = Math.max(height,rectangle[1]);
        }
        
        answer = rectangle[0]*rectangle[1];
        return answer;
    }
}