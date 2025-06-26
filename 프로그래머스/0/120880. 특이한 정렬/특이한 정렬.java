import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return IntStream.of(numlist)
            .boxed()
            .sorted(Comparator
                    .comparingInt((Integer i) -> Math.abs(n-i))
                    .thenComparing(i -> i,Comparator.reverseOrder()))
            .mapToInt(i->i)
            .toArray();
    }
}