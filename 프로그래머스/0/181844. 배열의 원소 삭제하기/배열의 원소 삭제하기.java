import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return IntStream.of(arr).filter(item ->
                !Arrays.stream(delete_list).anyMatch(delItem ->
                 item == delItem)).toArray();
    }
}