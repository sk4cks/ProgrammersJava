import java.util.stream.IntStream;

class Solution {
    public double solution(int[] numbers) {
        return IntStream.of(numbers).average().getAsDouble();
    }
}