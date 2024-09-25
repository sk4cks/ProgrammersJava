import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        int[] firstArr = {1,2,3,4,5};
        int[] secondArr = {2,1,2,3,2,4,2,5};
        int[] thirdArr = {3,3,1,1,2,2,4,4,5,5};
        int max = Integer.MIN_VALUE;

        for(int i=1; i<=3; i++){
            map.put(i,0);
        }

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == firstArr[i%firstArr.length]){
                map.put(1,map.get(1)+1);
            }
            if(answers[i] == secondArr[i%secondArr.length]){
                map.put(2,map.get(2)+1);
            }
            if(answers[i] == thirdArr[i%thirdArr.length]){
                map.put(3,map.get(3)+1);
            }
        }

        for(int i=1; i<=3; i++){
            max = Math.max(max,map.get(i));
        }

        for(int i=1; i<=3; i++){
            if(max == map.get(i)) answer.add(i);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
     
}