class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length; // 압축 안 했을 때 길이

        // 자르는 단위: 1 ~ length/2
        for (int unit = 1; unit <= length / 2; unit++) {
            StringBuilder result = new StringBuilder();

            String prev = s.substring(0, unit); // 이전 문자열
            int count = 1;

            // unit 단위로 순회
            for (int j = unit; j < length; j += unit) {
                int end = Math.min(length, j + unit);
                String curr = s.substring(j, end);

                if (prev.equals(curr)) {
                    count++;
                } else {
                    // 누적 결과 반영
                    if (count > 1) result.append(count);
                    result.append(prev);

                    prev = curr;
                    count = 1;
                }
            }

            // 마지막 남은 부분 처리
            if (count > 1) result.append(count);
            result.append(prev);

            // 최소 길이 갱신
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}