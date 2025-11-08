class Solution {
    public String solution(int n, int t, int m, int p) {
        // 🔸 16진수(최대) 표현용 배열 (0~F)
        String[] hexArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int max = t*m;  // 🔸 전체 필요한 숫자 개수: t(튜브가 말해야 할 개수) * m(참가자 수)
        int start = 0;  // 🔸 0부터 시작 (숫자 증가용)
        
        // 🔸 전체 게임 진행 중 생성되는 n진수 문자열을 담을 StringBuilder
        //     "0"은 게임이 0부터 시작하므로 미리 추가
        StringBuilder sb = new StringBuilder("0");
        StringBuilder answer = new StringBuilder(); // 🔸 최종 정답 (튜브가 말해야 할 문자만 담을)

        // 🔸 필요한 문자 개수(max)보다 sb의 길이가 작을 동안 n진수 문자열 생성
        while (sb.length()<=max){
            int value = ++start;    // 다음 숫자로 증가
            StringBuilder num = new StringBuilder();    // 현재 숫자(value)를 n진수로 변환하기 위한 StringBuilder
            
            // 🔹 n진수 변환 과정
            while (value > 0){
                int remain = value%n;   // 나머지 계산 (n진수 자리)
                num.insert(0, n>10 ? hexArr[remain] : remain);  // n이 10을 초과하면 10~15는 A~F로 변환
                value /= n;     // 몫으로 다음 자리 계산
            }
            
            sb.append(num); // 변환된 n진수 문자열을 전체 문자열에 이어붙임
        }

        // 🔸 p번째 플레이어(튜브)의 차례마다 말해야 할 문자 추출
        //     인덱스는 0부터 시작하므로 p-1에서 시작, m씩 건너뛴다.
        for(int i=p-1; i<max; i+=m) {
            answer.append(sb.charAt(i));
        }
        
        // 🔸 최종 결과 문자열 반환
        return answer.toString();
    }
}