class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr= new char[m][n];
        for(int i=0; i< m; i++){
            arr[i] = board[i].toCharArray();
        }

        while (true) {
            boolean flag = true;
            boolean[][] checkArr = new boolean[m][n];
            for(int i=m-1; i>0; i--){
                for(int j=n-1; j>0; j--){
                    if(arr[i][j] != '-' && arr[i][j]==arr[i][j-1] 
                       && arr[i][j-1]==arr[i-1][j-1] && arr[i-1][j-1]==arr[i-1][j]){
                        checkArr[i][j] = true;
                        checkArr[i][j-1] = true;
                        checkArr[i-1][j-1] = true;
                        checkArr[i-1][j] = true;
                        flag = false;
                    }
                }
            }

            if(flag) break;

            for(int i=m-1; i>=0; i--){
                for(int j=n-1; j>=0; j--){
                    if(checkArr[i][j]){
                        arr[i][j] = '-';
                        answer++;
                    }
                }
            }

            for(int i=m-1; i>=0; i--){
                for(int j=n-1; j>=0; j--){
                    if(arr[i][j]=='-'){
                        for(int k=i-1; k>=0; k--){
                            if(arr[k][j]!='-') {
                                arr[i][j] = arr[k][j];
                                arr[k][j] = '-';
                                break;
                            }
                        }
                    }
                }
            }

        }
        return answer;
    }
}