import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] nums = Arrays.asList(arr).stream()
            .mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(nums);
        
        answer = nums[0]+" "+nums[nums.length-1];
        
        return answer;
    }
}