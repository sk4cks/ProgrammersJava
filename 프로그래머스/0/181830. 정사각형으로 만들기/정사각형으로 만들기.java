import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr) {
        if(arr.length > arr[0].length) {
            for(int i=0; i<arr.length; i++) {
                arr[i] = Arrays.copyOf(arr[i],arr.length);
            }
        }else if(arr.length < arr[0].length) {
            int[][] newArr = new int[arr[0].length][arr[0].length];
            
            for(int i=0; i<arr.length; i++) {
                newArr[i] = arr[i];
            }
            
            arr = newArr;
        }
        
        return arr;
    }
}