import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        
        // 결과 배열 (초기엔 비어있고, 나중에 Set → 배열로 변환)
        int[] answer = {};
        
        // 두 수의 합을 저장할 Set (중복 자동 제거)
        Set<Integer> set = new HashSet<>();

        // 서로 다른 두 인덱스 i, j를 선택 (i < j)
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                
                // 두 수의 합을 Set에 추가 (중복은 자동으로 제거됨)
                set.add(numbers[i] + numbers[j]);
            }
        }

        // Set → int 배열로 변환
        // mapToInt : Integer → int 변환
        answer = set.stream().mapToInt(i -> i).toArray();
        
        // 오름차순 정렬
        Arrays.sort(answer);
        
        // 결과 반환
        return answer;
    }
}