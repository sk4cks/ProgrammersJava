class Solution {
    // 신호등 정보를 저장할 부분
    class TrafficLight {
        int greenLimit;
        int yelloLimit;
        int totalTime;

        public TrafficLight(int green, int yello, int red) {
            this.greenLimit = green;
            this.yelloLimit = green + yello;
            this.totalTime = green + yello + red;
        }
        // 노란불인지 확인
        public boolean isYello(int time) {
            // 시간 보정
            int colorTime = time % totalTime == 0 ? totalTime : time % totalTime;
            if (greenLimit < colorTime && colorTime <= yelloLimit) {
                return true;
            }
            return false;
        }
    }

    public int solution(int[][] signals) {
        // 만든 클래스에 적용
        TrafficLight[] trafficLights = new TrafficLight[signals.length];
        // 최대 검사 시간을 구하기 위한 배열
        int[] totalTimes = new int[signals.length];
        for (int i = 0; i < signals.length; i++) {
            trafficLights[i] =
                    new TrafficLight(signals[i][0], signals[i][1], signals[i][2]);
            totalTimes[i] = trafficLights[i].totalTime;
        }
        // 모두 노란불이 가능한지 판단하기 위한 최소 시간
        int maxTime = getLcm(totalTimes);
        for (int time = 1; time <= maxTime; time++) {
            boolean isEqaul = true;
            // 신호등 모드 노란불인지 확인
            for (int i = 0; i < trafficLights.length; i++) {
                if (!trafficLights[i].isYello(time)) {
                    isEqaul = false;
                    break;
                }
            }
            // 노란불인 경우 해당 시간 반환
            if (isEqaul) {
                return time;
            }
        }
        // 불가능하면 -1
        return -1;
    }

    public int getLcm(int[] nums) {
        // 1인 경우는 자기 자신이 최소 공배수
        if (nums.length == 1) {
            return nums[0];
        }
        // 첫 2개의 최대 공약수 구하여 최소 공배수 구하기
        int gcd = getGcd(nums[0], nums[1]);
        int lcm = (nums[0] * nums[1]) / gcd;
        // 2개 이상인 경우 계속 최소 공배수 구하기
        for (int i = 2; i < nums.length; i++) {
            gcd = getGcd(nums[i], lcm);
            lcm = (lcm * nums[i]) / gcd;
        }
        return lcm;
    }
    // 최대 공약수 구하기
    private int getGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGcd(num2, num1 % num2);
    }
}