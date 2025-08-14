import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int index = 0;
        int answer = 0;
        
        Arrays.sort(people);

        for(int i=people.length-1; i>=0; i--){
            if(index > i) break;
            
            if(people[i]+people[index] <= limit){
                index++;
            }
            
            answer++;
        }
        return answer;
    }
}