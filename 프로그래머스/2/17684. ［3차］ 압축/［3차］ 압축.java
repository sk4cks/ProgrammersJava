import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> dictionary = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder(msg);

        for(int i=0; i<26; i++) {
            dictionary.add(String.valueOf((char) ('A'+i)));
        }

        while (sb.length() > 0) {
            for(int i = dictionary.size()-1; i>=0; i--) {
                if(sb.toString().startsWith(dictionary.get(i))) {
                    answer.add(i+1);
                    dictionary.add(sb.substring(0,Math.min(dictionary.get(i).length()+1,sb.length())));
                    sb.delete(0,dictionary.get(i).length());
                    break;
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}