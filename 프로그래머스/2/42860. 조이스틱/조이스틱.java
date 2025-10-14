class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int max = length-1; //오른쪽으로만 가는 경우로 기본 max값 설정

        for (int i=0; i<length; i++) {
            char letter = name.charAt(i);
            // 1. 위 아래 이동 카운트
            // 위 또는 아래로 움직이는것중에 최소값 더하기
            answer += Math.min(letter - 'A', 'Z' - letter + 1);

            // 다음문자가 A면 패스하기 위해서 next++해줌
            int next = i+1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 2. 왼쪽 오른쪽 이동 카운트
            max = Math.min(max, i*2 + length-next); // 앞으로 갔다가 되돌아 오는 경우
            max = Math.min(max, (length-next) * 2 + i); // 뒤로 갔다가 되돌아 오는 경우
        }

        // 위아래 이동 + 왼쪽 오른쪽 이동
        answer += max;
        
        return answer;
    }
}