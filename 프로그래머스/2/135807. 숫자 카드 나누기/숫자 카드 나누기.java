import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int aGcd = getGcd(arrayA);  // arrayA 전체의 최대공약수
        int bGcd = getGcd(arrayB);  // arrayB 전체의 최대공약수 

        // aGcd가 arrayB의 어떤 원소도 나누지 못하면 후보로 사용
        answer = setAnswer(aGcd,arrayB,answer);
        // bGcd가 arrayA의 어떤 원소도 나누지 못하면 후보로 사용
        answer = setAnswer(bGcd,arrayA,answer);
        
        return answer;
    }
    
    // 배열 전체의 최대공약수를 구하는 메서드
    int getGcd(int[] arr) {
        int result = arr[0];    // 첫 번째 값을 기준으로 시작
        for (int i = 1; i < arr.length; i++) {
            result = getGcd(result, arr[i]);    // 누적해서 GCD 계산
        }
        
        return result;
    }
    
    // 두 수의 최대공약수를 구하는 메서드 (유클리드 호제법)
    int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    /**
     * gcd가 상대 배열의 어떤 값도 나누지 못하는지 확인하고
     * 조건을 만족하면 answer와 비교하여 최대값을 반환
     */
    int setAnswer(int gcd, int[] arr, int answer) {
        for(int i=0; i<arr.length; i++) {
            // gcd로 나누어 떨어지는 값이 하나라도 있으면 조건 불만족
            if(arr[i]%gcd==0) return answer;
        }

        // 조건을 만족하면 기존 answer와 gcd 중 큰 값 선택
        return Math.max(answer,gcd);
    }
}