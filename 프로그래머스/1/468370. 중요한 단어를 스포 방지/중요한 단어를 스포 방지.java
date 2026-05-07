import java.util.*;

class Solution {

    public int solution(String message, int[][] spoilerRanges) {

        // 스포일러 단어 저장
        List<String> spoilerWords = new ArrayList<>();

        // 스포일러가 아닌 단어 저장
        Set<String> safeWords = new HashSet<>();

        int searchIdx = 0;

        // 메시지를 단어 단위로 순회
        for (String word : message.split(" ")) {

            /*
             현재 단어의 실제 위치 탐색
             (동일 단어가 여러 번 등장할 수 있으므로 searchIdx부터 검색)
            */
            int start = message.indexOf(word, searchIdx);
            int end = start + word.length() - 1;

            // 다음 탐색 시작 위치 갱신
            searchIdx = end + 1;

            boolean isSpoiler = false;

            // 스포일러 범위와 겹치는지 확인
            for (int[] range : spoilerRanges) {

                /*
                 범위 겹침 조건
                 start <= rangeEnd && end >= rangeStart
                */
                if (start <= range[1] && end >= range[0]) {
                    spoilerWords.add(word);
                    isSpoiler = true;
                    break;
                }
            }

            // 스포일러 단어가 아니면 safeWords에 저장
            if (!isSpoiler) {
                safeWords.add(word);
            }
        }

        /*
         중요한 단어:
         - 스포일러 단어에는 포함
         - 안전 단어에는 포함되지 않음
        */
        Set<String> importantWords = new HashSet<>();

        for (String word : spoilerWords) {
            if (!safeWords.contains(word)) {
                importantWords.add(word);
            }
        }

        return importantWords.size();
    }
}