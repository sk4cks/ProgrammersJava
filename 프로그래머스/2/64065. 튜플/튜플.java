import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        
         // 각 숫자가 등장한 횟수를 저장할 Map
        Map<Integer,Integer> map = new HashMap<>();
        
        // 문자열에서 중괄호({, }) 제거
        // 예: "{{2,1,3,3}}" → "2,1,3,3"
        String newS = s.replaceAll("[{}]","");
        
        // 콤마(,) 기준으로 나눠 숫자 문자열 배열 생성
        // 예: ["2", "1", "3", "3"]
        String[] sArray = newS.split(",");

        // 각 숫자의 등장 횟수를 카운트
        for(int i=0; i< sArray.length; i++){
            map.put(Integer.parseInt(sArray[i]),
                    map.getOrDefault(Integer.parseInt(sArray[i]),0)+1);
        }
        
        // keySet()을 이용해 Map의 key(숫자)만 리스트로 변환
        List<Integer> answer = new ArrayList<>(map.keySet());
        
        // 등장 횟수가 많은 순서대로 내림차순 정렬
        // map.get(v2) - map.get(v1) 과 같은 의미
        Collections.sort(answer, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        // 정렬된 숫자 리스트 반환
        return answer;
    }
}