class Solution {

    // 신호등 정보 클래스
    class TrafficLight {

        int greenEnd;   // 초록불 끝나는 시간
        int yellowEnd;  // 노란불 끝나는 시간
        int cycle;      // 전체 주기

        public TrafficLight(int green, int yellow, int red) {
            this.greenEnd = green;
            this.yellowEnd = green + yellow;
            this.cycle = green + yellow + red;
        }

        // 특정 시간에 노란불인지 확인
        boolean isYellow(int time) {

            /*
             현재 사이클 기준 시간 계산
             예:
             cycle = 10
             time = 13 → current = 3
            */
            int current = time % cycle;

            // 나머지가 0이면 사이클 마지막 시간
            if (current == 0) {
                current = cycle;
            }

            // 노란불 범위인지 확인
            return greenEnd < current && current <= yellowEnd;
        }
    }

    public int solution(int[][] signals) {

        int n = signals.length;

        TrafficLight[] lights = new TrafficLight[n];
        int[] cycles = new int[n];

        // 신호등 객체 생성
        for (int i = 0; i < n; i++) {
            lights[i] = new TrafficLight(
                    signals[i][0],
                    signals[i][1],
                    signals[i][2]
            );

            cycles[i] = lights[i].cycle;
        }

        /*
         모든 신호 패턴은 최소공배수 이후 반복됨
         → LCM까지만 검사하면 충분
        */
        int limit = getLcm(cycles);

        // 모든 시간 탐색
        for (int time = 1; time <= limit; time++) {

            boolean isAllYellow = true;

            // 모든 신호등이 노란불인지 확인
            for (TrafficLight light : lights) {
                if (!light.isYellow(time)) {
                    isAllYellow = false;
                    break;
                }
            }

            // 전부 노란불이면 해당 시간 반환
            if (isAllYellow) {
                return time;
            }
        }

        // 끝까지 없으면 불가능
        return -1;
    }

    // 배열 전체의 최소공배수 계산
    int getLcm(int[] nums) {

        int lcm = nums[0];

        for (int i = 1; i < nums.length; i++) {
            lcm = lcm(lcm, nums[i]);
        }

        return lcm;
    }

    // 두 수의 최소공배수
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 최대공약수 (유클리드 호제법)
    int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}