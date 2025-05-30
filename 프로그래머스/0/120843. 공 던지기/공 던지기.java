class Solution {
    public int solution(int[] numbers, int k) {
        int index = 0;
        int answer = 0;
        
        for(int i=0; i<k; i++) {
            answer = numbers[index % numbers.length];
            index += 2;
        }
        
        return answer;
    }
}