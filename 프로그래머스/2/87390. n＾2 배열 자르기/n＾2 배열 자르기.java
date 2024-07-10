class Solution {
    public int[] solution(int n, long left, long right) {
        int index = 0;
        int[] answer = new int[(int) (right-left+1)];

        for(long i=left; i<=right; i++){
            long col = i%n;
            long row = i/n;
            answer[index++] = (int) (row < col ? row+1+(col-row) : row+1);
        }
        
        return answer;
    }
}