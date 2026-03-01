import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        // 각 target에 대한 결과 저장
        int[] answer = new int[targets.length];
        
        // 문자별 최소 입력 횟수 저장
        Map<String,Integer> map = new HashMap<>();

        /*
         1단계: keymap을 순회하면서
         각 문자의 최소 누름 횟수 저장
        */
        for(int i = 0; i < keymap.length; i++){
            
            // 문자열을 한 글자씩 분리
            String[] key = keymap[i].split("");
            
            for(int j = 0; j < key.length; j++){
                
                /*
                 이미 map에 값이 없거나
                 더 작은 누름 횟수를 발견하면 갱신
                 
                 j+1인 이유:
                 인덱스는 0부터 시작하지만
                 실제 누르는 횟수는 1부터 시작
                */
                if(map.get(key[j]) == null || 
                   map.get(key[j]) > j + 1){
                    
                    map.put(key[j], j + 1);
                }
            }
        }

        /*
         2단계: target 문자열 계산
        */
        for(int i = 0; i < targets.length; i++){
            
            String[] target = targets[i].split("");
            
            for(int j = 0; j < target.length; j++){
                
                // 해당 문자를 만들 수 없는 경우
                if(map.get(target[j]) == null){
                    answer[i] = -1;
                    break;
                }
                else{
                    // 누르는 횟수 누적
                    answer[i] += map.get(target[j]);
                }
            }
        }
        
        return answer;
    }
}