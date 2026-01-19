import java.util.*;

class Solution {
    
    // 모든 조건 조합을 키로, 해당 조건을 만족하는 지원자들의 점수 리스트를 값으로 저장
    private Map<String, List<Integer>> infoMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // 1. 모든 info를 조합하여 가능한 모든 조건 키를 생성하고 점수를 저장
        for (String applicant : info) {
            // 공백으로 분리 → [언어, 직군, 경력, 소울푸드, 점수]
            setInfoMap(applicant.split(" "), "", 0);
        }
        
        // 2. 각 조건 조합별 점수 리스트를 오름차순 정렬 (이분 탐색을 위해 필수!)
        for (String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }
        
        // 3. 각 쿼리 처리
        for (int i = 0; i < query.length; i++) {
            // " and " 제거 → "java and backend and senior and pizza 260" → "javabackendseniorpizza 260"
            String cleanedQuery = query[i].replace(" and ", "");
            
            // 공백으로 분리 → [조건조합문자열, 점수]
            String[] queryArr = cleanedQuery.split(" ");
            
            String conditionKey = queryArr[0];     // 예: "javabackendseniorpizza" 또는 "----"
            int targetScore = Integer.parseInt(queryArr[1]);
            
            // 해당 조건 조합이 존재하면 이분 탐색으로 점수 이상인 사람 수 구하기
            if (infoMap.containsKey(conditionKey)) {
                answer[i] = binarySearch(conditionKey, targetScore);
            }
            // 존재하지 않으면 0명
            else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    /**
     * 재귀적으로 가능한 모든 조건 조합을 생성하는 함수
     * @param infoArr   : 한 지원자의 정보 배열 (언어, 직군, 경력, 소울푸드, 점수)
     * @param current   : 지금까지 만든 조건 문자열
     * @param depth     : 현재 처리 중인 항목 인덱스 (0~3)
     */
    private void setInfoMap(String[] infoArr, String current, int depth) {
        // 4가지 조건(언어,직군,경력,소울푸드)을 모두 처리했으면
        if (depth == 4) {
            // 해당 조건 조합 키가 없으면 새 리스트 생성
            infoMap.computeIfAbsent(current, k -> new ArrayList<>());
            // 점수 추가
            infoMap.get(current).add(Integer.parseInt(infoArr[depth]));
            return;
        }
        
        // 1. "-" (해당 조건 무시) 선택
        setInfoMap(infoArr, current + "-", depth + 1);
        
        // 2. 실제 값 선택
        setInfoMap(infoArr, current + infoArr[depth], depth + 1);
    }
    
    /**
     * 이분 탐색으로 score 이상인 지원자 수를 구함
     * (정렬된 리스트에서 score 이상이 처음 나오는 위치를 찾아 뒤에 남은 개수 반환)
     * 
     * @param key   : 조건 조합 문자열 (맵의 키)
     * @param score : 기준 점수
     * @return      : 해당 조건을 만족하면서 score 이상인 지원자 수
     */
    private int binarySearch(String key, int score) {
        List<Integer> scores = infoMap.get(key);
        
        int start = 0;
        int end = scores.size() - 1;
        
        // lower bound 찾기: score 이상이 처음 나오는 위치를 찾음
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (scores.get(mid) < score) {
                // mid의 점수가 기준보다 작다 → 오른쪽 탐색
                start = mid + 1;
            } else {
                // mid의 점수가 기준 이상 → 왼쪽으로 더 좁혀봄 (더 작은 인덱스에 가능성 있음)
                end = mid - 1;
            }
        }
        
        // 루프 종료 후 start == score 이상인 첫 번째 위치
        // → start부터 끝까지가 score 이상인 사람들
        return scores.size() - start;
    }
}