import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        // 각 주문 문자열을 정렬 (조합을 생성할 때 순서가 섞이지 않도록)
        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);   // 알파벳 순 정렬
            orders[i] = new String(arr);
        }

        // 각 원하는 코스 길이(course[i])에 대해 반복
        for(int i=0; i<course.length; i++) {
            Map<String,Integer> map = new HashMap<>();  // 조합 -> 등장 횟수 저장

            // 전체 주문에서 해당 길이의 조합 생성
            for(int j=0; j<orders.length; j++) {
                // 주문 길이가 course[i]보다 크거나 같아야 조합 생성 가능
                if(course[i] <= orders[j].length()) {
                    combine(orders[j],course[i],0,"",map);
                }
            }

            // 2번 이상 나온 조합 중 최댓값 찾기
            int maxValue = map.values().stream()
                    .filter(value -> value > 1 )
                    .max(Integer::compareTo)
                    .orElse(Integer.MIN_VALUE);

            // 유효한 조합이 존재할 때(최대값이 갱신된 경우)
            if(maxValue > Integer.MIN_VALUE) {
                // 등장 횟수가 최대값과 같은 조합들 모두 수집
                List<String> maxKeys = map.entrySet().stream()
                        .filter(entry -> entry.getValue() == maxValue)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

                // 최댓값 조합들을 결과 리스트에 추가
                answer.addAll(maxKeys);
            }
        }
        
        // 사전순 정렬 후 배열로 변환하여 반환
        return answer.stream().sorted().toArray(String[]::new);
    }
    
    /**
     * 조합을 만들어 카운트하는 재귀 메서드
     * str : 현재 주문 문자열
     * r : 만들어야 하는 조합 길이
     * index : 현재 문자열의 어느 인덱스를 보고 있는지
     * current : 현재까지 선택된 메뉴 조합
     * map : 조합 등장 횟수 저장용
     */
    void combine(String str, int r, int index, String current, Map<String,Integer> map) {
        // 원하는 길이의 조합이 완성되면 map에 카운팅
        if (current.length() == r) {
            map.put(current,map.getOrDefault(current,0)+1);
            return;
        }
        
        // 문자열 끝까지 도달했으면 종료
        if (index >= str.length()) {
            return;
        }
        
        // 현재 문자를 포함시키는 경우
        combine(str, r, index + 1, current + str.charAt(index), map);
        // 현재 문자를 포함시키지 않는 경우
        combine(str, r, index + 1, current, map);
    }
}