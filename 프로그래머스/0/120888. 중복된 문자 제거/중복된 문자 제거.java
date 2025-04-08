class Solution {
    public String solution(String my_string) {
        String[] strArr = my_string.split("");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strArr.length; i++) {
            if(sb.indexOf(strArr[i]) == -1) {
                sb.append(strArr[i]);
            }
        }
        
        return sb.toString();
    }
}