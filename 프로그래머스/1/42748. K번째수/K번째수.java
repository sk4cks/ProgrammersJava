import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // 각 command의 결과를 저장할 배열
        int[] answer = new int[commands.length];

        // commands 배열을 하나씩 처리
        for(int i=0; i<commands.length; i++){
            
            // 잘라낸 배열을 담을 리스트
            List<Integer> list = new ArrayList<>();
            
            // commands[i][0] ~ commands[i][1] 구간을 자름
            // 문제는 1-based index라서 -1 해줌
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                list.add(array[j]);
            }
            
            // 잘라낸 배열을 오름차순 정렬
            Collections.sort(list);
            
            // commands[i][2]번째 값 선택 (이것도 1-based라 -1)
            answer[i] = list.get(commands[i][2]-1);
        }
        
        // 결과 배열 반환
        return answer;
    }
}