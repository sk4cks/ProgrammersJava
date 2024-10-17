import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        return Pattern.matches("^\\d{4}$|^\\d{6}$",s);
    }
}