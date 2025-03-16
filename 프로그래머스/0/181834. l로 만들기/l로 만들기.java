class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<myString.length(); i++) {
            sb.append(myString.charAt(i) < 'l' ? 'l' : myString.charAt(i));
        }
        
        return sb.toString();
    }
}