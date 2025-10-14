class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int max = length-1;

        for (int i=0; i<length; i++) {
            char letter = name.charAt(i);
            answer += Math.min(letter - 'A', 'Z' - letter + 1);

            int next = i+1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            max = Math.min(max, i*2 + length-next);
            max = Math.min(max, (length-next) * 2 + i);
        }

        answer += max;
        
        return answer;
    }
}