class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            // 1️⃣ 위/아래 이동
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 2️⃣ 좌/우 이동
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i * 2 + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }

        answer += move;
        
        return answer;
    }
}