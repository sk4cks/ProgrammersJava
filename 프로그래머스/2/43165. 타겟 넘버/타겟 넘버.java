class Solution {
    int answer = 0; // 타겟 넘버를 만들 수 있는 경우의 수
    
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);    // DFS 탐색 시작 (현재 합=0, 시작 인덱스=0)
        
        return answer;  // 가능한 조합의 수 반환
    }
    
    /**
     * @param numbers 숫자 배열
     * @param target 목표 값
     * @param number 현재까지의 누적 합
     * @param index 현재 탐색 중인 인덱스
     */
    void dfs(int[] numbers,int target,int number,int index){
        
        // 1️⃣ 모든 숫자를 다 사용했을 때 (탐색 종료 조건)
        if(index==numbers.length) {
            if(number == target) answer++;  // 누적합이 target과 같다면 경우의 수 증가
            return;
        }
        
        dfs(numbers,target,number+numbers[index],index+1);  // 2️⃣ 현재 숫자를 더하는 경우
        dfs(numbers,target,number-numbers[index],index+1);  // 3️⃣ 현재 숫자를 빼는 경우
    }
    
}