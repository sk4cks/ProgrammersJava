import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> current = new HashMap<>();

        // 1️⃣ 내가 사고 싶은 품목 및 개수 저장
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 2️⃣ 초기 10일 구간 등록
        for (int i = 0; i < 10 && i < discount.length; i++) {
            current.put(discount[i], current.getOrDefault(discount[i], 0) + 1);
        }
        
        // 3️⃣ 10일 단위로 윈도우 이동하면서 비교
        for (int i = 0; i <= discount.length - 10; i++) {
            // 3-1️⃣ 현재 구간이 wantMap과 동일한지 검사
            if (check(wantMap, current)) answer++;

            // 3-2️⃣ 윈도우 이동 (맨 앞 품목 제거, 다음 품목 추가)
            if (i + 10 < discount.length) {
                // 앞쪽 품목 제거
                String removeItem = discount[i];
                current.put(removeItem, current.get(removeItem) - 1);
                if (current.get(removeItem) == 0) current.remove(removeItem);

                // 새로운 품목 추가
                String addItem = discount[i + 10];
                current.put(addItem, current.getOrDefault(addItem, 0) + 1);
            }
        }
        
        return answer;
    }
    
    // 두 Map이 동일한지 비교하는 함수
    boolean check(Map<String, Integer> want, Map<String, Integer> current) {
        for (String key : want.keySet()) {
            if (current.getOrDefault(key, 0) != want.get(key)) return false;
        }
        return true;
    }
}