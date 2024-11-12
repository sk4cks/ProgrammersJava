class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(0,0,arr.length,arr);
        return answer;
    }
    
    void compress(int x, int y, int length, int[][] arr) {
        int value = arr[x][y];
        boolean isPressed = true;

        Loop:
        for(int i=x; i<x+length; i++) {
            for(int j=y; j<y+length; j++) {
                if(arr[i][j] != value) {
                    isPressed = false;
                    break Loop;
                }
            }
        }

        if(isPressed) answer[value]++;
        else{
            int k = length/2;
            compress(x,y,k,arr);
            compress(x,y+k,k,arr);
            compress(x+k,y,k,arr);
            compress(x+k,y+k,k,arr);
        }
    }
}