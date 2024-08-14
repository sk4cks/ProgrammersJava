class Solution {
    public int[] solution(int n) {
        int x = -1, y = 0;
        int start = 0, index = 0;
        int[][] arr = new int[n][n];
        int[] answer = new int[n*(n+1) / 2];
        for(int i=1; i<=n; i++){
           for(int j=i; j<=n; j++){
               switch (i%3) {
                   case 1:
                        x++;
                       break;
                   case 2:
                      y++;
                       break;
                   case 0:
                       x--;
                       y--;
                       break;
               }
               arr[x][y] = ++start;
           }
       }
        
       for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               if(arr[i][j]==0) break;
               answer[index++] = arr[i][j];
           }
       }
        return answer;
    }
}