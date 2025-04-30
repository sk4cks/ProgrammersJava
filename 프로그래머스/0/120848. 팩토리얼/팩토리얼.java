class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= 10; i++) {
            if (n >= factorial(i)) {
                answer = i;
            }else {
                break;                
            }
        }
        return answer;
    }

    int factorial(int number) {
        if (number > 1) return number * factorial(number - 1);
        return number;
    }
}