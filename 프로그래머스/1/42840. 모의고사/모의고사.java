import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        // 각 학생의 찍기 패턴
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        // 각 학생의 맞춘 문제 수
        int[] score = new int[3];

        // 정답과 각 학생 패턴 비교
        for(int i=0; i<answers.length; i++){
            if(answers[i] == first[i % first.length]) score[0]++;
            if(answers[i] == second[i % second.length]) score[1]++;
            if(answers[i] == third[i % third.length]) score[2]++;
        }

        // 최고 점수 찾기
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> result = new ArrayList<>();

        // 최고 점수인 학생 찾기
        for(int i=0; i<3; i++){
            if(score[i] == max){
                result.add(i+1); // 학생 번호는 1부터
            }
        }

        // List → int 배열 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}