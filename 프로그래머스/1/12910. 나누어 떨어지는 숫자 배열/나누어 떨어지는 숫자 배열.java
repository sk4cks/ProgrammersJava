import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = IntStream.of(arr).filter(i -> i%divisor==0).sorted().toArray();
        if(answer.length==0) answer = new int[]{-1};
        
        return answer;
    }
}