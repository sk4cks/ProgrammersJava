class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long min = 1;
        long max = limit;

        while (min < max) {
            long mid = (min + max) / 2;
            long time = times[0];

            for(int i=1; i<diffs.length; i++) {
                if(mid < diffs[i]) {
                    time += (diffs[i] - mid) * (times[i] + times[i-1]);
                }
                time += times[i];
            }

            if(time <= limit) {
                max = mid;
            }else{
                min = mid+1;
            }
        }
        
        return (int) min;
    }
}