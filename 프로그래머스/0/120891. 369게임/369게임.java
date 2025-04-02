class Solution {
    public int solution(int order) {
        int answer = 0;
        
        while(order > 0) {
            int remain = order%10;
            if(remain%3 == 0 && remain/3 > 0) answer++;
            
            order /= 10;
        }
        
        return answer;
    }
}