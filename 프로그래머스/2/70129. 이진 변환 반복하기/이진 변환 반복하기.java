class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")){
            answer[0]++;
            int original = s.length();
            s = s.replaceAll("0","");
            int length = s.length();
            answer[1] += (original-length);
            s = Integer.toBinaryString(length);
        }
        
        return answer;
    }
}