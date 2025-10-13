class Solution {
    public int solution(String name) {
        int answer = 0;             // 최종 이동 횟수
        int len = name.length();    // 이름의 길이
        int move = len - 1;         // 기본 좌/우 이동 횟수 (끝까지 한쪽으로 가는 경우)

        for (int i = 0; i < len; i++) {
            // 1️⃣ 위/아래 이동 (각 문자 맞추기)
            char c = name.charAt(i);
            // A부터 Z까지는 26글자.
            // 위로 이동: c - 'A'번, 아래로 이동: 'Z' - c + 1번
            // 둘 중 더 작은 값을 선택 (예: A→Z보다 Z→A가 더 짧은 경우)
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 2️⃣ 좌/우 이동 최소값 탐색
            int next = i + 1;
            // 다음 문자가 'A'인 경우는 스킵 (움직이지 않아도 되니까)
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            // i번째까지 갔다가 되돌아가서 끝까지 가는 경우
            // 예: "JEROEN"에서 중간에 A들이 있는 경우 돌아가는 루트 고려
            move = Math.min(move, i * 2 + len - next);
            
            // 뒤쪽에서 시작해 반대편으로 돌아오는 경우
            // 예: "JAN"처럼 끝에서 돌아올 때 더 짧은 경우 고려
            move = Math.min(move, (len - next) * 2 + i);
        }

        // 위/아래 이동 + 좌/우 이동
        answer += move;
        
        return answer;
    }
}