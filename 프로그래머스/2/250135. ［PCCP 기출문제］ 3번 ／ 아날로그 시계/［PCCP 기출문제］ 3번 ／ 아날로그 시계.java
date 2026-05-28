class Solution {  
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        double start = h1 * 3600 + m1 * 60 + s1;
        double end = h2 * 3600 + m2 * 60 + s2;

        if (start == 0 || start == 12 * 3600) {
            answer++;
        }

        while (start < end) {
            double hour = start / 120 % 360; // 12시간(43200초)마다 360°
            double minute = start / 10 % 360; // 1시간(3600초)마다 360°
            double second = start * 6 % 360; // 60초마다 360°

            double nextHour = calc((start + 1) / 120 % 360);
            double nextMinute = calc((start + 1) / 10 % 360);
            double nextSecond = calc((start + 1) * 6 % 360);

            if (second < minute && nextMinute <= nextSecond) {
                answer++;
            }
            if (second < hour && nextHour <= nextSecond) {
                answer++;
            }
            if (nextSecond == nextMinute && nextMinute == nextHour) {
                answer--;
            }

            start++;
        }

        return answer;
    }
    
    double calc(double degree) {
        return degree == 0 ? 360 : degree;
    }
}
