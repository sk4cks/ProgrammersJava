import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<String> set = new HashSet<>();
        long[] xRange = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] yRange = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};

        for (int i=0; i<line.length-1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for (int j=i+1; j< line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a*d - b*c;
                long bfed = b*f - e*d;
                long ecaf = e*c - a*f;

                if (adbc != 0) {
                    if (bfed % adbc == 0 && ecaf % adbc == 0) {
                        long x = bfed / adbc;
                        long y = ecaf / adbc;
                        set.add(x  + "," + y);

                        xRange[0] = Math.min(xRange[0], x);
                        xRange[1] = Math.max(xRange[1], x);
                        yRange[0] = Math.min(yRange[0], y);
                        yRange[1] = Math.max(yRange[1], y);

                    }
                }
            }
        }

        long width = xRange[1] - xRange[0] + 1;
        long height = yRange[1] - yRange[0] + 1;
        List<StringBuilder> list = new ArrayList<>();

        for (int i=0; i<height; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j=0; j<width; j++) {
                sb.append(".");
            }

            list.add(sb);
        }

        for (String point : set) {
            String[] pointArr = point.split(",");
            int x = (int) (Long.parseLong(pointArr[0]) - xRange[0]);
            int y = (int) (yRange[1] - Long.parseLong(pointArr[1]));

            list.get(y).setCharAt(x, '*');
        }

        String[] answer = new String[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).toString();
        }
        
        return answer;
    }
}