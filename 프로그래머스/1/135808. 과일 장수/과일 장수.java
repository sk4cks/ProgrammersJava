import java.util.Arrays;
import java.util.Collections;


class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] integerScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(integerScore, Collections.reverseOrder());

        for(int i=m-1; i<integerScore.length; i+=m){
            answer += integerScore[i]*m;
        }
        
        return answer;
    }
}