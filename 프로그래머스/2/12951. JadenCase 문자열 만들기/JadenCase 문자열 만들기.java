class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for(int i=0; i<s.length(); i++){
            String word =  String.valueOf(s.charAt(i)).toLowerCase();
            if(word.equals(" ")) flag = true;
            else if(flag) {
                word = word.toUpperCase();
                flag = false;
            }
            sb.append(word);
        }
        
        return sb.toString();
    }
}