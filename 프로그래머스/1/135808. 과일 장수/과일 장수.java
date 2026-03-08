import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0; // 최종 수익
        
        // int 배열을 Integer 배열로 변환 (Collections.reverseOrder 사용하려면 Integer 필요)
        Integer[] integerScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        
        // 점수를 내림차순으로 정렬 (높은 점수부터 사용하기 위해)
        Arrays.sort(integerScore, Collections.reverseOrder());

        // m개씩 박스를 만들기 위해 m-1 인덱스부터 시작
        // 예: m=3이면 index 2가 첫 박스의 최저 점수
        for(int i = m-1; i < integerScore.length; i += m){
            
            // 박스 가격 = (박스 내 최저 점수) × m
            // 내림차순이므로 integerScore[i]가 해당 박스의 최저 점수
            answer += integerScore[i] * m;
        }
        
        return answer; // 총 수익 반환
    }
}