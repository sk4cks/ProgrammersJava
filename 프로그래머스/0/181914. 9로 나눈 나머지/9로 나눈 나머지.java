class Solution {
    public int solution(String number) {
        int plus = 0;

        for(int i=0; i<number.length(); i++) {
            plus += Character.getNumericValue(number.charAt(i));
        }
        
        return plus%9;
    }
}