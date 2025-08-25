class Solution {

    char[][] map;

    public int solution(String[] board) {
        
        map = new char[3][3];
        int oCnt = 0;
        int xCnt = 0;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                map[i][j] = board[i].charAt(j);

                switch(map[i][j]) {
                    case 'O':
                        oCnt++;
                        break;
                    case 'X':
                        xCnt++;
                        break;
                }
            }
        }
        
        //O가 x보다 작으면 위반, O가 X보다 2개이상 많으면 위반
        if( oCnt < xCnt || oCnt > (xCnt + 1) ) {
            return 0;
        }

        //O가 이겼는데 x카운트의 개수가 하나 작지 않으면 위반
        if(checkWin('O') && oCnt != xCnt + 1) {
            return 0;
        }

        //X가 이겼는데 O카운트랑 x카운트랑 같지 않으면 위반
        if(checkWin('X') && oCnt != xCnt) {
            return 0;
        }
        
        return 1;
    }

    boolean checkWin(char target) {
        for(int i=0; i<3; i++) {
            //가로 검사
            if(map[i][0] == target && map[i][1] == target && map[i][2] == target) {
                return true;
            }
            //세로 검사
            if(map[0][i] == target && map[1][i] == target && map[2][i] == target) {
                return true;
            }
        }

        //대각선 검사
        if(map[0][0] == target && map[1][1] == target && map[2][2] == target) {
            return true;
        }
        if(map[0][2] == target && map[1][1] == target && map[2][0] == target) {
            return true;
        }

        return false;
    }
}