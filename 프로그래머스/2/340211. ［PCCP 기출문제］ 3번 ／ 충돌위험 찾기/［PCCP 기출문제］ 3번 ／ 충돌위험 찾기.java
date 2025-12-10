import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<List<String>> paths = new ArrayList<>();
        int answer = 0;
        int maxLength = 0;

        for (int[] route : routes) {
            List<String> path = new ArrayList<>();
            int[] start = points[route[0]-1].clone();
            path.add(start[0] + "," + start[1]);

            for (int i=1; i<route.length; i++) {
                int[] end = points[route[i]-1].clone();

                int r = end[0] - start[0];
                int c = end[1] - start[1];

                setPath(r, start,"r",path);
                setPath(c, start,"c",path);
            }

            maxLength = Math.max(maxLength, path.size());
            paths.add(path);
        }

        for (int i=0; i<maxLength; i++) {
            Map<String, Integer> map = new HashMap<>();

            for (List<String> path : paths) {
                if (path.size() > i) {
                    map.put(path.get(i), map.getOrDefault(path.get(i), 0) + 1);
                }
            }
            
            for (String key : map.keySet()) {
                if (map.get(key) > 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    void setPath(int diff, int[] start, String type, List<String> path) {

        int dn = diff < 0 ? -1 : 1;
        int dr = type.equals("r") ? dn : 0;
        int dc = type.equals("c") ? dn : 0;

        int count = Math.abs(diff);

        for (int i=0; i<count; i++) {
            start[0] += dr;
            start[1] += dc;
            path.add(start[0] + "," + start[1]);
        }
    }
}