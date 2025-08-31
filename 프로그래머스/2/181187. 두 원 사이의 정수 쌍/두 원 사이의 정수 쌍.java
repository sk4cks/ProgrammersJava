class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        //y=0일때를 안세는 이유는
        //y=0 점들은 아예 빼먹음 (개수 부족)
        //x=0 점들은 2배로 많이 셈 (개수 과잉)
        
        //1사분면의 개수를 세고 *4를 하면 딱 맞다

        for (int y = 1; y <= r2; y++) { // (1)
            int x2 = (int) Math.sqrt(Math.pow(r2, 2) - Math.pow(y, 2)); // (2)
            int x1 = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(y, 2))); // (3)
            
            answer += x2 - x1 + 1; // (4)
        }
        
        return answer * 4;
    }
}