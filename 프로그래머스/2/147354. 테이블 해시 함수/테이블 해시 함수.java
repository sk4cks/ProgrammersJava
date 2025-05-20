import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        row_begin--;
        
        Arrays.sort(data, (a, b) -> {
            int cmp = Integer.compare(a[col-1], b[col-1]);
            return cmp != 0 ? cmp : Integer.compare(b[0], a[0]);
        });
        
        for(int i=row_begin; i<row_end; i++) {
            int finalI = i + 1;
            answer ^= Arrays.stream(data[i]).map(item -> item % finalI).sum();
        }
        
        return answer;
    }
}