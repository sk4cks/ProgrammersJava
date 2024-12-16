import java.util.stream.IntStream;

class Solution {
    public int solution(int[] array, int height) {
        return IntStream.of(array).filter(i -> i > height).toArray().length;
    }
}