class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=0; i<s.length(); i++){
            String word =  String.valueOf(s.charAt(i));
            if(word.equals(" ")) {
                sb.append(" ");
                flag = true;
            }else {
                if(flag){
                    sb.append(word.toUpperCase());
                    flag = false;
                }else{
                    sb.append(word.toLowerCase());
                }
            }
        }
        
        return sb.toString();
    }
}