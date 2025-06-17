import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[score.length];

        for(int[] arr : score) {
            list.add(arr[0]+arr[1]);
        }

        Collections.sort(list,Comparator.reverseOrder());

        for(int i=0; i<score.length; i++) {
            answer[i] = list.indexOf(score[i][0]+score[i][1]) + 1;
        }
        
        return answer;
    }
}