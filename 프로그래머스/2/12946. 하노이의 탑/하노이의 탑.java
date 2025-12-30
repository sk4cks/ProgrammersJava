import java.util.*;

class Solution {
    
    // 원판 이동 경로를 저장할 리스트
    // 각 요소는 [출발 기둥, 도착 기둥]
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        // n개의 원판을 1번 기둥에서 3번 기둥으로 이동
        // 2번 기둥은 보조 기둥으로 사용
        hanoi(n,1,3,2);
        
        // List<int[]> → int[][] 변환 후 반환
        return list.toArray(new int[list.size()][]);
    }
    
    // 하노이의 탑 재귀 함수
    // n     : 이동할 원판 개수
    // start : 출발 기둥
    // end   : 도착 기둥
    // mid   : 보조 기둥
    void hanoi(int n, int start, int end, int mid) {
        
        // 원판이 없으면 종료 (재귀 탈출 조건)
        if(n == 0) return;

        // 1️⃣ 위의 n-1개 원판을 start → mid 로 이동
        hanoi(n-1,start,mid,end);
        
        // 2️⃣ 가장 큰 원판 1개를 start → end 로 이동
        list.add(new int[]{start,end});
        
        // 3️⃣ mid에 옮겨둔 n-1개 원판을 mid → end 로 이동
        hanoi(n-1,mid,end,start);
    }
}