import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int pow = 0;

        while (arr.length > Math.pow(2,pow)) {
            pow++;
        }

        return Arrays.copyOf(arr, (int) Math.pow(2,pow));
    }
}