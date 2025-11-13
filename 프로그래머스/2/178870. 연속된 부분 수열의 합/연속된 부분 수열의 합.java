class Solution {
    public int[] solution(int[] sequence, int k) {
        // 결과 구간의 시작과 끝 인덱스를 저장할 배열
        int[] answer = new int[2];
        
        int N = sequence.length;    // 수열의 길이
        int range = N;              // 현재까지 찾은 최소 구간 길이 (초기값: 최대길이)
        int sum = 0;                // 현재 구간의 합
        
        // 투 포인터(two pointer) 방식 사용
        // L: 구간의 왼쪽 포인터, R: 구간의 오른쪽 포인터
        for(int L=0,R=0;L< N;L++){
            // 🔹 R을 오른쪽으로 이동시키면서 sum이 k 이상이 될 때까지 더함
            while (R<N && sum<k){
                sum+=sequence[R++];
            }
            
            // 🔹 현재 구간의 합이 k인 경우 → 최소 길이 갱신
            if(sum==k && range >R-L-1){
                range = R-L-1;  // 새로운 최소 길이로 갱신
                answer[0] = L;  // 시작 인덱스
                answer[1] = R-1;    // 끝 인덱스 (R은 이미 1칸 더 간 상태)
            }
            
            // 🔹 왼쪽 포인터(L)를 오른쪽으로 한 칸 이동시키기 전,
            //     L 위치의 값을 sum에서 빼줌 (구간을 좁히는 과정)
            sum-=sequence[L];
        }
        
        // 찾은 가장 짧은 구간의 [시작, 끝] 인덱스 반환
        return answer;
    }
}