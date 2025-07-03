class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            answer[i] =  (Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) * (arr[1].equals("+") ? 1 : -1)
                          == Integer.parseInt(arr[4]) ? "O" : "X");
        }
        
        return answer;
    }
}