class Solution {
    
    char[] friends = {'A','C','F','J','M','N','R','T'};
    boolean[] visited = new boolean[8];
    int answer = 0;
    
    public int solution(int n, String[] data) {
        dfs("",0, data);
        
        return answer;
    }
    
    void dfs(String line, int length, String[] data) {
        if (length == 8) {
            checkLine(line, data);
            return;
        }

        for (int i=0; i<8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(line + friends[i], length+1, data);
                visited[i] = false;
            }
        }
    }
    
    void checkLine(String line, String[] data) {
        for (String condition : data) {
            int diff = Math.abs(line.indexOf(condition.charAt(0)) - line.indexOf(condition.charAt(2))) - 1;
            int gap = condition.charAt(4) - '0';

            switch (condition.charAt(3)) {
                case '=':
                    if (diff != gap) return;
                    break;
                case '<':
                    if (diff >= gap) return;
                    break;
                case '>':
                    if (diff <= gap) return;
                    break;
            }
        }

        answer++;
    }
    
}