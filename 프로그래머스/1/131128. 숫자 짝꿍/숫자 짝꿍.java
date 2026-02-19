import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        // 기본값을 "-1"로 세팅
        // 공통 숫자가 하나도 없을 경우 그대로 반환
        StringBuilder answer = new StringBuilder("-1");
        
        // X와 Y 각각의 숫자 등장 횟수를 저장할 맵
        Map<Character,Integer> xMap = new HashMap<>();
        Map<Character,Integer> yMap = new HashMap<>();
        
        // 공통 숫자를 담을 리스트
        List<Character> list = new ArrayList<>();

        // X 문자열에서 각 숫자의 개수 카운트
        for (int i=0; i<X.length(); i++){
            xMap.put(X.charAt(i),
                     xMap.getOrDefault(X.charAt(i),0)+1);
        }
        
        // Y 문자열에서 각 숫자의 개수 카운트
        for (int i=0; i<Y.length(); i++){
            yMap.put(Y.charAt(i),
                     yMap.getOrDefault(Y.charAt(i),0)+1);
        }

        // X에 있는 숫자 기준으로
        // Y에도 존재하는 숫자만 처리
        for (Character key : xMap.keySet()){
            if (yMap.containsKey(key)){
                
                // 두 문자열에 공통으로 존재하는 개수 중
                // 더 작은 값만큼 사용
                int count = Math.min(xMap.get(key), yMap.get(key));
                
                // 해당 숫자를 count만큼 리스트에 추가
                for (int i=0; i<count; i++){
                    list.add(key);
                }
            }
        }

        // 숫자를 큰 값부터 나오도록 내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        // 공통 숫자가 하나라도 있는 경우
        if (list.size() > 0) {
            
            // 기존 "-1" 제거
            answer.setLength(0);
            
            // 정렬된 숫자를 이어붙이기
            for (int i=0; i<list.size(); i++){
                answer.append(list.get(i));
            }
            
            /*
             예외 처리:
             결과가 "0000" 같은 경우
             가장 큰 숫자가 '0'이면
             전체가 0으로만 구성된 것
             
             → 결과는 "0" 하나만 반환
            */
            if (answer.charAt(0) == '0'){
                answer.setLength(0);
                answer.append(0);
            }
        }
        
        return answer.toString();
    }
}