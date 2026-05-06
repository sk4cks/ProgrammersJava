import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        // 시크릿 문자들 저장
        int curIdx = 0;
        List<String> spoilerWords = new ArrayList<>();
        Set<String> noSpoilerWords = new HashSet<>();
        for (String word : message.split(" ")) {
            // 단어를 검사하고 시작할 위치를 해당 단어 뒤로 지정
            // 똑같은 단어 나올때를 방지
            int start = message.indexOf(word, curIdx);
            int end = start + word.length() - 1;
            curIdx = end + 1;
            // 스포일러 범위에 조금이라도 걸치면 스포일러 단어에 저장
            boolean isSpoiler = false;
            for (int[] range: spoiler_ranges) {
                if (start <= range[1] && end >= range[0]) {
                    spoilerWords.add(word);
                    isSpoiler = true;
                    break;
                }
            }
            // 스포일러 단어가 아니면 아닌 단어들에 저장
            if (!isSpoiler) {
                noSpoilerWords.add(word);
            }
        }
        // 중요한 단어인지 확인
        Set<String> importantWords = new HashSet<>();
        for (String spoilerWord : spoilerWords) {
            // 중요한 단어에 이미 포함되지 않고 
            // 스포일러가 아닌 단어에 포함되지 않으면 중요한 단어
            if (!importantWords.contains(spoilerWord) && 
                    !noSpoilerWords.contains(spoilerWord)) {
                importantWords.add(spoilerWord);
            }
        }
        return importantWords.size();
    }
}