class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
           int remainder = storey%10;
           if(remainder > 5){
               int count = 10-remainder;
               answer+= count;
               storey += count;
           }else if (remainder == 5){
               if(((storey/10)%10)+1 > 5){
                   int count = 10-remainder;
                   answer+= count;
                   storey += count;
               }else{
                   answer += remainder;
               }
           }else {
               answer += remainder;
           }
           storey /= 10;
        }
        return answer;
    }
}