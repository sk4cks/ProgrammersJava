class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    boolean[][] visited;
    char[][] map;

    int n;
    int m;
    int answer;
    
    public int solution(String[] storage, String[] requests) {
        
        n = storage.length;
        m = storage[0].length();
        map = new char[n][m];
        answer = n * m;
        
        //storage배열을 2차원배열로 초기화
        for(int i=0; i<storage.length; i++) {
           map[i] = storage[i].toCharArray();
        }
        
        // 출고 요청 for
        for(int i=0; i<requests.length; i++) {
            char container = requests[i].charAt(0);

            if(requests[i].length() > 1) { //크레인
                useCrain(container);
            } else { //지게차
                useCar(container);
            }
        }
        
        return answer;
    }
    
    //크레인 사용일경우
    void useCrain(char container) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == container) {
                    map[i][j] = 0;
                    answer--;
                }
            }
        }
    }
    
    //지게차 사용일경우
    void useCar(char container) {
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) { // 행 기준 for
            if(!visited[i][0]) dfs(i, 0, container); // 왼쪽 경계 탐색
            if(!visited[i][m-1]) dfs(i, m-1, container); // 오른쪽 경계 탐색
        }

        for(int i=0; i<m; i++) { // 열 기준 for
            if(!visited[0][i]) dfs(0, i, container); // 위쪽 경계 탐색
            if(!visited[n-1][i]) dfs(n-1, i, container); // 아래쪽 경계 탐색
        }
    }
    
    void dfs(int x, int y, char container) {
        visited[x][y] = true;

        if(map[x][y] == 0) { //이미 꺼내진 컨테이너일경우
            for(int i=0; i<dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny]) dfs(nx, ny, container);
                }
            }
        }

        if(map[x][y] == container) { //꺼낼수 있는 컨테이너일경우
            map[x][y] = 0;
            answer--;
        }
    }
    
}