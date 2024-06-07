import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        
        nums = Arrays.stream(nums).distinct().toArray();
        if(length/2 < nums.length){
            answer = length/2;
        }else{
            answer = nums.length;
        }
        
        
        return answer;
    }
}