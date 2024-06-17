import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        List<String> tmpCards1 = new ArrayList<>();
        List<String> tmpCards2 = new ArrayList<>();

        Loop1 :
        for(int i=0; i<goal.length; i++){
            for(int j=0; j<cards1.length; j++){
                if(goal[i].equals(cards1[j])){
                    tmpCards1.add(goal[i]);
                    continue Loop1;
                }
            }

            for(int j=0; j<cards2.length; j++){
                if(goal[i].equals(cards2[j])){
                    tmpCards2.add(goal[i]);
                    continue Loop1;
                }
            }
        }

        for(int i=0; i<tmpCards1.size(); i++){
            if(!cards1[i].equals(tmpCards1.get(i))) return "No";
        }

        for(int i=0; i<tmpCards2.size(); i++){
            if(!cards2[i].equals(tmpCards2.get(i))) return "No";
        }

        return answer;
    }
}