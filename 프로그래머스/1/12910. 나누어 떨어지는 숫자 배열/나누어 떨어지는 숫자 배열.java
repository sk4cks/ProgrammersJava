import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // arr 배열에서 divisor로 나누어 떨어지는 요소만 필터링 후 오름차순 정렬
        int[] answer = IntStream.of(arr)
                                .filter(i -> i % divisor == 0)
                                .sorted()
                                .toArray();
        
        // 나누어 떨어지는 요소가 없으면 [-1] 반환
        if (answer.length == 0) {
            answer = new int[]{-1};
        }
        
        return answer;
    }
}