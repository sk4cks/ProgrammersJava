import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0; // 처음 방문한 길의 개수
        Set<String> set = new HashSet<>();  // 방문한 길(간선)을 저장할 Set (중복 방지)
        
        // 1️⃣ 각 방향(U, D, R, L)에 따른 이동 좌표 변화량 정의
        Map<Character,int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});  // 위로 이동 (y + 1)
        map.put('D', new int[]{0, -1}); // 아래로 이동 (y - 1)
        map.put('R', new int[]{1, 0});  // 오른쪽 이동 (x + 1)
        map.put('L', new int[]{-1, 0}); // 왼쪽 이동 (x - 1)

        // 2️⃣ 시작 좌표 (0,0)
        int x = 0;
        int y = 0;

        // 3️⃣ 주어진 명령(dirs) 하나씩 수행
        for(int i=0; i<dirs.length(); i++){
            String oldPoint = ""+x+y;   // 현재 좌표를 문자열로 저장 (예: "00")
            char dir = dirs.charAt(i);  // 이동 방향
            
            // 이동 후 좌표 계산
            int newX = x+map.get(dir)[0];
            int newY = y+map.get(dir)[1];

            // 4️⃣ 좌표평면 범위 벗어나면 무시 (좌표는 -5 ~ 5 사이)
            if(Math.abs(newX) > 5 || Math.abs(newY) > 5) continue;

            // 이동 후 좌표를 문자열로 저장
            String newPoint = ""+newX+newY;
            
            // 5️⃣ 처음 가보는 길이면 (양방향 모두 확인)
            // oldPoint -> newPoint / newPoint -> oldPoint 둘 다 체크해야 같은 길 중복 방지 가능
            if( !set.contains(oldPoint+newPoint) ||
               !set.contains(newPoint+oldPoint)) {
                set.add(oldPoint+newPoint);
                set.add(newPoint+oldPoint);
                answer++;   // 새로운 길이므로 카운트 증가
            }

            // 6️⃣ 현재 좌표를 새 위치로 갱신
            x = newX;
            y = newY;
        }
        
        return answer;  // 7️⃣ 방문한 길의 개수 반환
    }
}