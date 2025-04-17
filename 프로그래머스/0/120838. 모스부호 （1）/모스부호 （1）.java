import java.util.*;

class Solution {
    public String solution(String letter) {
        List<String> mos = Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");
        String[] splitLetter = letter.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<splitLetter.length; i++) {
            sb.append( (char)('a' + mos.indexOf(splitLetter[i])) + "");
        }
        
        return sb.toString();
    }
}