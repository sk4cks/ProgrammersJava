import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[^\\d]","");
        int[] arr = new int[my_string.length()];
        
        for (int i=0; i<my_string.length(); i++) {
            arr[i] = Character.getNumericValue(my_string.charAt(i));
        }
        
        Arrays.sort(arr);
        
        return arr;
    }
}