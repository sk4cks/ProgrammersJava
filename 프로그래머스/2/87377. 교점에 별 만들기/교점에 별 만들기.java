import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        // 교점 좌표를 "x,y" 형태로 저장 (중복 제거용)
        Set<String> set = new HashSet<>();
        
        // x, y 좌표의 최소/최대 범위 저장
        long[] xRange = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] yRange = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};

        // 1. 모든 직선 쌍에 대해 교점 계산
        for (int i=0; i<line.length-1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for (int j=i+1; j< line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a*d - b*c;  // 연립방정식의 분모 (ad - bc)
                
                // 분자가 될 값들
                long bfed = b*f - e*d;
                long ecaf = e*c - a*f;

                // 2. 평행 또는 일치하지 않는 경우만 처리
                if (adbc != 0) {
                    
                    // 3. 교점이 정수 좌표인 경우만 사용
                    if (bfed % adbc == 0 && ecaf % adbc == 0) {
                        long x = bfed / adbc;
                        long y = ecaf / adbc;
                        
                        set.add(x  + "," + y);  // 교점 저장

                        // 좌표 범위 갱신
                        xRange[0] = Math.min(xRange[0], x);
                        xRange[1] = Math.max(xRange[1], x);
                        yRange[0] = Math.min(yRange[0], y);
                        yRange[1] = Math.max(yRange[1], y);

                    }
                }
            }
        }

        // 4. 출력할 좌표 평면의 가로/세로 크기 계산
        long width = xRange[1] - xRange[0] + 1;
        long height = yRange[1] - yRange[0] + 1;
        
        // 5. 전체를 '.'으로 채운 2차원 문자열 생성
        List<StringBuilder> list = new ArrayList<>();

        for (int i=0; i<height; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j=0; j<width; j++) {
                sb.append(".");
            }

            list.add(sb);
        }

        // 6. 교점 위치에 '*' 표시
        for (String point : set) {
            String[] pointArr = point.split(",");
            
            // x좌표는 최소값 기준으로 보정
            int x = (int) (Long.parseLong(pointArr[0]) - xRange[0]);
            
            // y좌표는 위에서 아래로 내려오도록 뒤집어서 보정
            int y = (int) (yRange[1] - Long.parseLong(pointArr[1]));

            list.get(y).setCharAt(x, '*');
        }

        // 7. List<StringBuilder> → String[] 변환
        String[] answer = new String[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).toString();
        }
        
        return answer;
    }
}