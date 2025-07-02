import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n,1,3,2);
        
        return list.toArray(new int[list.size()][]);
    }
    
    void hanoi(int n, int start, int end, int mid) {
        if(n == 0) return;

        hanoi(n-1,start,mid,end);
        list.add(new int[]{start,end});
        hanoi(n-1,mid,end,start);
    }
}