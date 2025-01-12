import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int k) {
        return IntStream.of(arr).map(i -> k%2 == 0 ? i+k : i*k).toArray();
    }
}