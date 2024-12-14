import java.util.stream.IntStream;

class Solution {
    public int solution(int[] array, int n) {
        return IntStream.of(array).filter(i -> i==n).toArray().length;
    }
}