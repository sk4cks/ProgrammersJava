class Solution {
    public int solution(int n) {
        // 🔹 DP(동적 계획법) 배열 선언
        // n이 1 또는 2일 때 인덱스 에러를 방지하기 위해 n+3 크기로 생성
        int[] arr = new int[n+3];
        
        // 🔸 초기값 설정
        // 2×1 크기를 채우는 방법은 1가지 (세로 타일 1개)
        arr[1] = 1;
        // 2×2 크기를 채우는 방법은 2가지 (세로 2개 or 가로 2개)
        arr[2] = 2;
        
        // 🔹 점화식: arr[i] = arr[i-1] + arr[i-2]
        // 이유: 
        //  - 마지막에 세로 타일 1개를 놓는 경우 → arr[i-1]
        //  - 마지막에 가로 타일 2개를 놓는 경우 → arr[i-2]
        // 두 경우를 합친 것이 전체 경우의 수
        for(int i=3; i<=n; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }
        
        return arr[n];
    }
}