import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for(int i=1; i< words.length; i++) {
            char last = words[i-1].charAt(words[i-1].length()-1);
            char first = words[i].charAt(0);
            if(last!=first || set.contains(words[i])){
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
                answer[1] = answer[0]==n ? ((i+1)/n) : ((i+1)/n)+1;
                break;
            }
            set.add(words[i]);
        }

        return answer;
    }
}