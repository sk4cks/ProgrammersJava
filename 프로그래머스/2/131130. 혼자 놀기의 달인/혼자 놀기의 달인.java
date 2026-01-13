import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        // 각 카드(인덱스)의 방문 여부 체크 배열
        boolean[] visited = new boolean[cards.length];
        
        // 각 카드(인덱스)의 방문 여부 체크 배열
        List<Integer> countList = new ArrayList<>();
        
        // 모든 카드에 대해 그룹 탐색
        for(int i=0; i<cards.length; i++) {
            int curIndex = i;   // 현재 탐색 중인 카드 인덱스
            int count = 0;      // 현재 그룹의 카드 개수

            // 아직 방문하지 않은 카드라면 그룹 탐색 시작
            while (!visited[curIndex]) {
                count++;        // 그룹 카드 수 증가
                visited[curIndex] = true;   // 현재 카드 방문 처리
                
                // 카드에 적힌 숫자는 다음 카드 번호 (1부터 시작하므로 -1)
                curIndex = cards[curIndex]-1;
            }

            // 하나의 그룹 탐색이 끝나면 카드 개수 저장
            if(count > 0) {
                countList.add(count);
            }
        }
        
        // 그룹이 2개 이상일 경우
        if(countList.size() > 1) {
            // 그룹 크기를 내림차순으로 정렬
            countList.sort(Collections.reverseOrder());
            
            // 가장 큰 두 그룹의 카드 개수를 곱하여 점수 계산
            answer = countList.get(0) * countList.get(1);
        }
        
        return answer;
    }
}