import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] type = {'R','T','C','F','J','M','A','N'};
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<type.length; i++){
            map.put(type[i],0);
        }

        for(int i=0; i<survey.length; i++){
            int index = choices[i]>4 ? 1 : 0;
            char target = survey[i].charAt(index);
            int score = index==0 ? 4-choices[i] : choices[i]-4;
            map.put(target,map.get(target)+score);
        }

        for(int i=0; i<type.length; i+=2){
            answer += map.get(type[i]) >= map.get(type[i+1]) ? type[i] : type[i+1];
        }
        
        return answer;
    }
}