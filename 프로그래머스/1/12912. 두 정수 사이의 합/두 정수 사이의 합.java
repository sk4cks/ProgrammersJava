import java.util.stream.LongStream;

class Solution {
    public long solution(int a, int b) {
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        
        return LongStream.rangeClosed(min,max).sum();
    }
}