import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();

        Loop:
            for(int i=l; i<=r; i++) {
                String num = String.valueOf(i);
                char[] numArr = num.toCharArray();
                for(int j=0; j<numArr.length; j++) {
                    if(numArr[j] != '0' && numArr[j] != '5') {
                        continue Loop;
                    }
                }
                list.add(i);
            }
        
        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
    }
}