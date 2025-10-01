import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // 의상 종류별로 "경우의 수"를 저장할 맵 (key: 의상종류, value: 경우의 수)
        Map<String,Integer> map = new HashMap<>();
        
        // 최종 결과 (경우의 수를 곱하기 위해 1로 초기화)
        int answer = 1;

        // 1️⃣ 의상 데이터를 순회하며 종류별로 개수를 세기
        for(int i=0; i<clothes.length; i++) {
            // clothes[i][1] → 의상 종류 (예: "headgear", "eyewear")
            // map.getOrDefault(종류, 1) → 해당 종류가 아직 없으면 "1"을 기본값으로 줌
            //  → "아예 안 입는 경우"를 포함시키기 위해 기본값을 1로 둠
            // 그 뒤 +1 해서 실제 옷 개수를 반영
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1)+1);
        }

        // 2️⃣ 각 종류별 경우의 수를 곱하기
        // 예: 모자(headgear) = 3가지(안쓰기, 모자1, 모자2)
        //     안경(eyewear)  = 2가지(안쓰기, 선글라스)
        //     전체 경우의 수 = 3 × 2 = 6
        for (int count : map.values()) {
            answer *= count;
        }
        
        // 3️⃣ "아무것도 안 입는 경우"를 제외해야 함
        //    따라서 최종 결과에서 -1
        return --answer;
    }
}