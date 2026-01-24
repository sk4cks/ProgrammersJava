import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        // 각 로봇이 시간 순서대로 방문하는 좌표 경로 저장
        List<List<String>> paths = new ArrayList<>();
        
        int answer = 0;
        int maxLength = 0;  // 가장 오래 움직이는 로봇의 경로 길이 (시간 길이)

        // 1. 각 로봇(route)에 대해 이동 경로 생성
        for (int[] route : routes) {
            List<String> path = new ArrayList<>();
            
            // 시작 좌표
            int[] start = points[route[0]-1].clone();
            path.add(start[0] + "," + start[1]);

            // 경유지들을 순서대로 이동
            for (int i=1; i<route.length; i++) {
                int[] end = points[route[i]-1].clone();

                int r = end[0] - start[0];  // 행 이동 거리
                int c = end[1] - start[1];  // 열 이동 거리

                // 문제 조건: 행(r) 먼저 이동 후, 열(c) 이동
                setPath(r, start,"r",path);
                setPath(c, start,"c",path);
            }

            // 가장 긴 경로 길이 갱신 (전체 시간 길이 결정)
            maxLength = Math.max(maxLength, path.size());
            paths.add(path);
        }

        // 2. 시간별로 모든 로봇의 위치를 비교
        for (int i=0; i<maxLength; i++) {
            
            // 해당 시간(i)에 각 좌표에 몇 대의 로봇이 있는지 저장
            Map<String, Integer> map = new HashMap<>();

            for (List<String> path : paths) {
                
                // 해당 시간까지 이동한 로봇만 체크
                if (path.size() > i) {
                    map.put(path.get(i), map.getOrDefault(path.get(i), 0) + 1);
                }
            }
            
            // 같은 좌표에 2대 이상 있으면 충돌 발생
            for (String key : map.keySet()) {
                if (map.get(key) > 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    // diff 만큼 start 좌표를 한 칸씩 이동시키며 경로에 추가
    void setPath(int diff, int[] start, String type, List<String> path) {

        // 이동 방향 결정 (양수: +1, 음수: -1)
        int dn = diff < 0 ? -1 : 1;
        
        // r 이동인지, c 이동인지에 따라 증감 방향 설정
        int dr = type.equals("r") ? dn : 0;
        int dc = type.equals("c") ? dn : 0;

        int count = Math.abs(diff); // 이동해야 할 칸 수

        for (int i=0; i<count; i++) {
            start[0] += dr;
            start[1] += dc;
            
            // 매 시간마다 좌표를 경로에 저장
            path.add(start[0] + "," + start[1]);
        }
    }
}