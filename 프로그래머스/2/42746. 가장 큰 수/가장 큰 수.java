import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] numbers) {
        
        // 결과 문자열을 담을 StringBuilder
        StringBuilder sb = new StringBuilder();

        // numbers 배열을 IntStream으로 변환하여 처리
        List<Integer> result =IntStream.of(numbers)
                .boxed()    // int -> Integer로 변환
            
                // 정렬 기준: 두 숫자를 이어붙여 더 큰 숫자가 되도록 정렬 
                // 예: 9와 34 비교 → "934" vs "349" 
                // 더 큰 조합이 앞으로 오게 하기 위해 내림차순 정렬
                .sorted((a,b) -> (String.valueOf(b)+a).compareTo(String.valueOf(a)+b))
                .collect(Collectors.toList());

        // 정렬된 숫자를 문자열로 이어붙임
        result.forEach(item -> sb.append(item));
        
        // 가장 앞자리가 '0'이면 모든 숫자가 0인 경우 → "0" 반환
        if(sb.charAt(0)=='0') return "0";
                
        // 최종 문자열 반환
        return sb.toString();
    }
}