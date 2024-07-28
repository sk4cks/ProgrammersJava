import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        Map<Character,int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('R', new int[]{1, 0});
        map.put('L', new int[]{-1, 0});

        int x = 0;
        int y = 0;

        for(int i=0; i<dirs.length(); i++){
            String oldPoint = ""+x+y;
            char dir = dirs.charAt(i);
            int newX = x+map.get(dir)[0];
            int newY = y+map.get(dir)[1];

            if(Math.abs(newX) > 5 || Math.abs(newY) > 5) continue;

            String newPoint = ""+newX+newY;
            if( !set.contains(oldPoint+newPoint) ||  !set.contains(newPoint+oldPoint)) {
                set.add(oldPoint+newPoint);
                set.add(newPoint+oldPoint);
                answer++;
            }

            x = newX;
            y = newY;
        }
        return answer;
    }
}