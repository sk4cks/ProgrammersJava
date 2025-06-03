import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        arr = Arrays.stream(arr).distinct().toArray();
        int[] newArr = Arrays.copyOf(arr,k);

        if(arr.length < k) {
            for(int i=arr.length; i<newArr.length; i++) {
                newArr[i] = -1;
            }
        }
        
        return newArr;
    }
}