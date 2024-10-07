import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] copyArr = arr.clone();
        int[] answer = {-1};

        Arrays.sort(copyArr);
        int min = copyArr[0];

        for(int i=0; i<arr.length; i++) {
            if(min != arr[i]) list.add(arr[i]);
        }

        if(list.size() > 0) answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}