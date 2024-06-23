class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] splitString = s.split("");
         answer[0] = -1;

        for(int i=1; i< splitString.length; i++){
            answer[i] = -1;
            for(int j= i-1; j>=0; j--){
                if(splitString[i].equals(splitString[j])){
                    answer[i] = i-j;
                    break;
                }
            }
        }
        return answer;
    }
}