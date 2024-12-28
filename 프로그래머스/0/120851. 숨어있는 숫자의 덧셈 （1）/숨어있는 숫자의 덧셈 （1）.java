class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[^\\d]","");

        for(int i=0; i<my_string.length(); i++) {
            answer += Character.getNumericValue(my_string.charAt(i));
        }
        
        return answer;
    }
}