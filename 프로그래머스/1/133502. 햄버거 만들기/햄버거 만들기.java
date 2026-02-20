import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0; // 완성된 햄버거 개수
        
        // 재료를 순서대로 쌓아둘 리스트 (스택처럼 사용)
        List<Integer> list = new ArrayList<>();
        
        // 재료를 하나씩 처리
        for(int i=0; i<ingredient.length; i++){
            
            // 현재 재료 추가
            list.add(ingredient[i]);
            
            /*
             햄버거 패턴 확인
             패턴: 1 (빵) - 2 (야채) - 3 (고기) - 1 (빵)
             
             마지막 4개의 재료가 이 패턴이면 햄버거 완성
            */
            if(list.size() >= 4 && 
                list.get(list.size()-1) == 1 &&
                list.get(list.size()-2) == 3 &&
                list.get(list.size()-3) == 2 &&
                list.get(list.size()-4) == 1){
                
                // 햄버거에 사용된 재료 4개 제거
                for(int j=0; j<4; j++){
                    list.remove(list.size()-1);
                }
                
                // 햄버거 개수 증가
                answer++;
            }

        }
        
        return answer;
    }
}