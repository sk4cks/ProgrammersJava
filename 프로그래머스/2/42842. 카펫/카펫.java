import java.util.HashMap;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown+yellow;
        
        for(int i=3; i<=area; i++){
            int quotient = area/i;
            if(area%i==0 && quotient > 2){
                int width = Math.max(i,quotient);
                int height = Math.min(i,quotient);

                if(yellow == (width-2) * (height-2)){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }
    
    
}