class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while (chicken >= 10) {
            int order = chicken / 10;
            answer += order;
            chicken = order + chicken % 10;
        }
        
        return answer;
    }
}