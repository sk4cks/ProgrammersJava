import java.util.*;

class Solution {
    String[] arr;       // 입력 숫자를 한 자리씩 나눈 배열
    boolean[] visited;  // 각 자리 숫자의 사용 여부 체크
    Set<Integer> set = new HashSet<>(); // 만들어진 모든 숫자를 중복 없이 저장
    
    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.split("");    // 문자열을 한 글자씩 분리 ("17" → ["1","7"])
        visited = new boolean[arr.length];  // 방문 여부 배열 초기화
        
        dfs(0,"");  // DFS로 만들 수 있는 모든 숫자 조합 생성
        
        // 만들어진 숫자 중 소수만 카운트
        for(int num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    /**
     * DFS를 이용해 숫자 조합 생성
     * depth  : 현재 사용한 자리 수
     * number : 지금까지 만든 숫자 문자열
     */
    void dfs(int depth, String number) {
        // 모든 자리를 다 사용했으면 더 이상 탐색할 필요 없음
        if(depth == arr.length) return;

        for(int i=0; i<arr.length; i++) {
            // 아직 사용하지 않은 숫자라면
            if(!visited[i]) {
                // 현재 숫자 + 새로운 자리 숫자를 정수로 변환해 Set에 저장
                set.add(Integer.parseInt(number+arr[i]));
                
                // 해당 숫자 사용 처리
                visited[i] = true;
                
                // 다음 자리 탐색
                dfs(depth+1,number+arr[i]);
                
                // 백트래킹: 사용 여부 원상복구
                visited[i] = false;
            }
        }
    }
    
    /**
     * 소수 판별 메서드
     */
    boolean isPrime(int num) {
        // 2 미만은 소수가 아님
        if(num<2) return false;

        int limit = (int)Math.sqrt(num);
        for(int i=2; i<=limit; i++) {
            // 2부터 √num 까지만 나눠보면 충분
            if(num%i==0) return false;
        }

        return true;
    }
}