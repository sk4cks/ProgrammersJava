import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] arr = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(A);
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<A.length; i++){
            answer += A[i]*arr[i];
        }

        return answer;
    }
}