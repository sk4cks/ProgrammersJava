import java.util.*;

class Solution {

    public String[] solution(String[] files) {

        Arrays.sort(files, (a, b) -> {

            // HEAD 추출 후 대소문자 무시 비교
            String headA = getHead(a).toLowerCase();
            String headB = getHead(b).toLowerCase();

            int headCompare = headA.compareTo(headB);

            // HEAD가 다르면 HEAD 기준 정렬
            if (headCompare != 0) {
                return headCompare;
            }

            // HEAD가 같으면 NUMBER 기준 정렬
            int numberA = getNumber(a);
            int numberB = getNumber(b);

            return Integer.compare(numberA, numberB);
        });

        return files;
    }

    // HEAD 추출
    String getHead(String file) {

        int idx = 0;

        // 숫자가 나오기 전까지 탐색
        while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
            idx++;
        }

        return file.substring(0, idx);
    }

    // NUMBER 추출
    int getNumber(String file) {

        int start = 0;

        // 숫자 시작 위치 찾기
        while (!Character.isDigit(file.charAt(start))) {
            start++;
        }

        int end = start;

        /*
         숫자 최대 5자리까지만 추출
         (문제 조건)
        */
        while (end < file.length()
                && Character.isDigit(file.charAt(end))
                && end - start < 5) {
            end++;
        }

        return Integer.parseInt(file.substring(start, end));
    }
}