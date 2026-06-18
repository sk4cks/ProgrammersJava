import java.util.*;

class Solution {
    public int[] solution(String s) {

        // 각 문자에 대한 결과를 저장할 배열
        // answer[i] = 현재 문자와 가장 가까운 같은 문자의 거리
        int[] answer = new int[s.length()];

        // 문자와 해당 문자가 마지막으로 등장한 위치(index)를 저장
        Map<Character, Integer> map = new HashMap<>();

        // 문자열을 처음부터 순회
        for (int i = 0; i < s.length(); i++) {

            // 현재 문자
            char c = s.charAt(i);

            // 이전에 같은 문자가 등장한 적이 있는 경우
            if (map.containsKey(c)) {

                // 현재 위치 - 이전 등장 위치
                // = 가장 가까운 같은 문자까지의 거리
                answer[i] = i - map.get(c);

            } else {

                // 처음 등장한 문자라면 같은 문자가 없으므로 -1
                answer[i] = -1;
            }

            // 현재 문자의 최신 위치로 갱신
            // 이후 같은 문자가 나오면 이 위치를 기준으로 거리 계산
            map.put(c, i);
        }

        return answer;
    }
}