import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        // 🔹 콜라츠 수열 값을 순서대로 저장
        List<Integer> list = new ArrayList<>();
        
        // 각 구간별 적분 결과를 저장할 배열
        double[] answer = new double[ranges.length];
        
        // 시작값 k 추가
        list.add(k);
        
        // 🔹 콜라츠 수열 생성 (k → 1)
        while (k > 1) {
            
            // 짝수면 2로 나눔
            if (k%2 == 0) {
                k /= 2;
             
            // 홀수면 3k + 1
            } else {
                k = k * 3 + 1;
            }
            
            list.add(k);
        }
        
        // 🔹 구간 넓이 누적합 배열
        // areaSumList[i] : 0번 ~ i번 구간까지의 넓이 합
        double[] areaSumList = new double[list.size()];
        
        for(int i=1; i<areaSumList.length; i++) {
            
            // i-1 ~ i 구간의 사다리꼴 넓이
            double area = (list.get(i) + list.get(i-1)) / 2.0;
            
            // 누적 합 계산
            areaSumList[i] = areaSumList[i-1] + area;
        }
        
        // 🔹 각 범위(ranges)에 대해 적분 결과 계산
        for(int i=0; i<ranges.length; i++) {
            int s = ranges[i][0];   // 시작 인덱스
            int e = list.size() - 1 + ranges[i][1]; // 끝 인덱스 (전체 길이 기준 음수 보정)

            // 시작점이 끝점보다 크면 유효하지 않은 구간
            if (s > e) {
                answer[i] = -1;
                
            // 누적합을 이용한 구간 넓이 계산
            } else {
                answer[i] = areaSumList[e] - areaSumList[s];
            }
        }
        
        // 모든 구간 결과 반환
        return answer;
    }
}