import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) {
            return arr2.length > arr1.length ? -1 : 1 ;
        }
        
        int sum1 = IntStream.of(arr1).sum();
        int sum2 = IntStream.of(arr2).sum();
        
        if(sum1 != sum2) {
            return sum2 > sum1 ? -1 : 1 ;
        }
        
        
        return 0;
    }
}