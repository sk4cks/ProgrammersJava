import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 🔸 스킬 순서를 큐(Queue)에 저장
        //     예: skill = "CBD" → [C, B, D]
        Queue<String> que = new LinkedList<>();
        for(int i=0; i<skill.length(); i++){
            que.add(String.valueOf(skill.charAt(i)));
        }

        // 🔸 각 스킬트리(skill_trees)마다 유효성 검사
        for(int i=0;i< skill_trees.length; i++){
            // 현재 스킬트리를 문자 배열로 변환
            String[] skillList = skill_trees[i].split("");
            
            // 원본 스킬 순서 큐를 복사 (각 트리마다 새로 사용해야 함)
            Queue<String> copyQue = new LinkedList<>(que);
            
            // flag = true → 올바른 스킬트리라고 가정
            boolean flag = true;
            
            // 🔸 스킬트리의 각 문자를 순서대로 탐색
            for(int j=0; j<skillList.length; j++){
                // 이미 모든 스킬을 배웠으면 중단
                if(copyQue.size()==0) {
                    break;
                    
                // 스킬 순서에 존재하는 문자인 경우 && 현재 배워야 하는 스킬 순서와 다르면 잘못된 스킬트리
                } else if(copyQue.contains(skillList[j]) &&
                         !copyQue.poll().equals(skillList[j])){
                    flag = false;
                    break;
                }
            }
            
            // 스킬 순서에 어긋나지 않았다면 유효한 스킬트리로 카운트
            if(flag) answer++;
        }
        
        return answer;
    }
}