import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // 이름과 그리움 점수를 저장할 Map
        // key : 이름(name)
        // value : 그리움 점수(yearning)
        Map<String,Integer> map = new HashMap<>();
        
        // 각 사진의 총 그리움 점수를 저장할 배열
        int[] answer = new int[photo.length];
        
        // name과 yearning 배열을 Map에 저장
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }

        // 사진 배열을 순회
        for(int i=0; i<photo.length; i++){
            
            // 사진 속 사람 이름들을 순회
            for(int j=0; j<photo[i].length; j++){
                
                // 해당 이름이 Map에 존재하면 그리움 점수를 더하고
                // 존재하지 않으면 0을 더함
                answer[i] += 
                    ( map.get(photo[i][j]) == null ? 0 : map.get(photo[i][j]) );
            }
        }
        
        // 각 사진의 총 그리움 점수 배열 반환
        return answer;
    }
}