class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char word = s.charAt(i);

            if(word != ' '){
                int seq = 0;
                if(97 <= word && word <= 122) seq = 97;
                if(65 <= word && word <= 90) seq = 65;

                word = (char) ((word+n)%seq);
                if(word > 25) word  = (char) ((word%25)-1);
                word = (char) (word + seq) ;
            }
            sb.append(word);
        }
        
        return sb.toString();
    }
}