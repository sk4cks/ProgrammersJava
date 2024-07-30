import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();

        for(int i=0; i<skill.length(); i++){
            que.add(String.valueOf(skill.charAt(i)));
        }

        for(int i=0;i< skill_trees.length; i++){
            String[] skillList = skill_trees[i].split("");
            Queue<String> copyQue = new LinkedList<>(que);
            boolean flag = true;
            for(int j=0; j<skillList.length; j++){
                if(copyQue.size()==0){
                    break;
                }else if(copyQue.contains(skillList[j]) &&
                         !copyQue.poll().equals(skillList[j])){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}