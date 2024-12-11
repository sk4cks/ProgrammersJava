import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int aGcd = getGcd(arrayA);
        int bGcd = getGcd(arrayB);

        answer = setAnswer(aGcd,arrayB,answer);
        answer = setAnswer(bGcd,arrayA,answer);
        
        return answer;
    }
    
    int getGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = getGcd(result, arr[i]);
        }
        return result;
    }
    
    int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
    
    int setAnswer(int gcd, int[] arr, int answer) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%gcd==0) return answer;
        }

        return Math.max(answer,gcd);
    }
}