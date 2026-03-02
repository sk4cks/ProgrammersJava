import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] answer = {};
        
        // 각 스테이지에 머물러 있는 사람 수 저장
        Map<Integer,Integer> map = new HashMap<>();
        
        // 각 스테이지의 실패율 저장
        Map<Integer,Double> stageMap = new HashMap<>();
        
        // 정렬을 위한 스테이지 번호 리스트
        List<Integer> list = new ArrayList<>();

        /*
         1단계
         각 스테이지에 현재 머물러 있는 사람 수 카운트
         (stages 배열에는 현재 도전 중인 스테이지가 들어있음)
        */
        for(int i = 0; i < stages.length; i++){
            map.put(stages[i],
                    map.getOrDefault(stages[i], 0) + 1);
        }

        /*
         2단계
         1번 ~ N번 스테이지까지 실패율 계산
        */
        for(int i = 1; i <= N; i++){
            
            double failureRate = 0;
            int count = 0;      // i번 이상 도전한 사람 수
           
            // i번 이상 스테이지에 있는 사람 수 계산
            for(int key : map.keySet()){
                if(i <= key) 
                    count += map.get(key);
            }
            
            // i번 스테이지에서 실패한 사람 수
            int failCount = map.getOrDefault(i, 0);

            // 분모가 0이 아닐 때만 실패율 계산
            if(count != 0 && failCount != 0)
                failureRate = (double) failCount / count;

            // 스테이지 번호와 실패율 저장
            stageMap.put(i, failureRate);
            
            // 정렬을 위해 리스트에 스테이지 번호 추가
            list.add(i);
        }

        /*
         3단계
         실패율 기준 내림차순 정렬
         (실패율이 높은 스테이지부터)
        */
        list.sort((a, b) -> 
            stageMap.get(b).compareTo(stageMap.get(a))
        );

        // List<Integer> → int[] 변환
        answer = list.stream()
                     .mapToInt(i -> i)
                     .toArray();
        
        return answer;
    }
}