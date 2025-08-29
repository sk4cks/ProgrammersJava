import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]); //첫번째 단어는 무조건 통과

        for(int i=1; i< words.length; i++) {
            char last = words[i-1].charAt(words[i-1].length()-1); //이전 단어의 마지막 글자
            char first = words[i].charAt(0); //현재 단어의 첫번째 글자
            
            //last랑 first가 다르거나 이미 이전에 등장했던 단어면
            if(last!=first || set.contains(words[i])){
                answer[0] = i % n + 1; // 사람 번호
                answer[1] = i / n + 1; // 몇 번째 차례
                break;
            }
            
            set.add(words[i]); //탈락하지 않았다면 단어를 set에 추가
        }

        return answer;
    }
}