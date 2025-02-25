class Solution {
    public int solution(int[] num_list) {
        int multiply = 1;
        int plus = 0;
        
        for(int i=0; i<num_list.length; i++) {
            multiply *= num_list[i];
            plus += num_list[i];
        }
        
        return multiply < Math.pow(plus,2) ? 1 : 0;
    }
}