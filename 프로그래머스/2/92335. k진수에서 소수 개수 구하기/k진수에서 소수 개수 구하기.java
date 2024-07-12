class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convertNumber = convertDecimalToBase(n,k);

        String[] numbers = convertNumber.split("0");
        for(int i=0; i<numbers.length; i++){
            if(!numbers[i].equals("") 
               && isPrime(Long.parseLong(numbers[i]))) answer++;
        }
        
        return answer;
    }
    
    String convertDecimalToBase(int decimal, int base) {
        StringBuilder sb = new StringBuilder();

        // 10진수 정수가 0이 될 때까지 반복
        while (decimal > 0) {
            // 10진수 정수를 base로 나눈 나머지(n진법으로 변환된 수)
            int temp = decimal % base;

            if (temp >= 10) { // 나머지 값이 10 이상이면, 'a'부터 시작하는 문자로 변환
                sb.append((char) (temp - 10 + 'a'));
            } else { // 나머지 값이 10 미만이면 그대로 사용
                sb.append(temp);
            }

            // 다음 숫자를 구하기 위한 나눗셈
            decimal = decimal / base;
        }

        // 문자열 뒤집기
        return sb.reverse().toString();
    }
    
    boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {			// n의 제곱근까지 나누기
            if (n % i == 0) return false;
        }
        return true;
    }
}