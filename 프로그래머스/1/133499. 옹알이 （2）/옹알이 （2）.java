class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        // 각 단어 검사
        for (String b : babbling) {
            int idx = 0;          // 현재 검사 위치
            String prev = "";     // 직전에 사용한 발음 (연속 방지)

            while (idx < b.length()) {
                boolean matched = false;

                // 4가지 발음 중 하나와 매칭되는지 확인
                for (String w : words) {

                    // 이전 발음과 같은 경우 → 연속 사용 금지
                    if (w.equals(prev)) continue;

                    // 현재 위치에서 해당 발음으로 시작하는지 검사
                    if (b.startsWith(w, idx)) {
                        idx += w.length();  // 해당 길이만큼 이동
                        prev = w;           // 이전 발음 저장
                        matched = true;
                        break;
                    }
                }

                // 어떤 발음과도 매칭되지 않으면 실패
                if (!matched) break;
            }

            // 끝까지 정상적으로 검사했으면 카운트
            if (idx == b.length()) answer++;
        }

        return answer;
    }
}