class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 숫자를 영어로 표현한 문자열 배열 (인덱스 = 실제 숫자)
        String[] a = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
        // 0 ~ 9까지 순회하면서
        for(int i=0;i<a.length;i++)
            
            // 문자열 s 안에 있는 영어 숫자를 실제 숫자로 치환
            // ex) "one" -> "1", "two" -> "2"
            s = s.replace(a[i], String.valueOf(i));
		
        // 최종적으로 숫자로만 이루어진 문자열을 정수로 변환
        answer = Integer.parseInt(s);
		
        // 결과 반환
        return answer;
    }
}