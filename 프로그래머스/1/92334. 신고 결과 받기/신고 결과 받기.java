import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        // 각 유저가 받게 될 메일 수 (정답)
        int[] answer = new int[id_list.length];

        // r1 : "신고당한 사람" → "신고한 사람들" 집합 (중복 신고 제거용)
        HashMap<String, HashSet<String>> r1 = new HashMap<>();

        // a1 : "신고한 사람" → "메일 받을 횟수"
        HashMap<String, Integer> a1 = new HashMap<>();

        // 1. 초기 세팅
        // 모든 유저에 대해 빈 신고자 집합과 메일 카운트 0으로 초기화
        for (int i = 0; i < id_list.length; i++) {
            r1.put(id_list[i], new HashSet<>());
            a1.put(id_list[i], 0);
        }

        // 2. 신고 기록 저장
        // report: "신고한사람 신고당한사람"
        for (String s : report) {
            String[] w = s.split(" ");
            // w[1]을 w[0]이 신고함
            r1.get(w[1]).add(w[0]);  // HashSet이라 중복 신고 자동 제거
        }

        // 3. 신고당한 사람 기준으로 처리
        for (String reportedUser : r1.keySet()) {
            HashSet<String> reporters = r1.get(reportedUser);

            // 신고 횟수가 k 이상이면 정지 대상
            if (reporters.size() >= k) {

                // 해당 유저를 신고한 사람들은 메일 1개씩 받음
                for (String reporter : reporters) {
                    a1.put(reporter, a1.get(reporter) + 1);
                }
            }
        }

        // 4. id_list 순서대로 메일 받을 횟수 answer에 담기
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = a1.get(id_list[i]);
        }

        return answer;
    }
}