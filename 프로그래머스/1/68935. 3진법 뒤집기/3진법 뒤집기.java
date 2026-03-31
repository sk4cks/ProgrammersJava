class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 3진법 변환 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // n을 3으로 나누면서 3진법으로 변환
        while (n > 0){
            
            // n % 3 → 현재 자릿수 값
            // insert(0, ...) → 앞에 붙여서 정상적인 3진법 형태로 만듦
            sb.insert(0, n % 3);
            
            // 다음 자릿수 계산
            n /= 3;
        }

        // 뒤집힌 3진법을 다시 10진법으로 변환
        for(int i=0; i<sb.length(); i++) {
            
            // sb.charAt(i) → 각 자릿수
            // 3^i 를 곱해서 10진수로 변환
            answer += 
                Integer.parseInt(String.valueOf(sb.charAt(i))) * (int)Math.pow(3, i);
        }
        
        return answer;
    }
}