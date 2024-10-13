class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char word = s.charAt(i);

            if(word != ' '){
                char ch = 'A';
                if(Character.isLowerCase(word)) ch = 'a';

                word = (char) ((word - ch + n)%26 + ch);
            }
            sb.append(word);
        }
        
        return sb.toString();
    }
}