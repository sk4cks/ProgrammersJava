import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] numlist) {
        return IntStream.of(numlist).filter(i -> i%n == 0).toArray();
    }
}