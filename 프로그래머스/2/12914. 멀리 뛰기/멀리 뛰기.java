class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[n+3]; // n+3 크기의 배열 생성 (인덱스 안전하게 확보)

        arr[1]=1;   // 1칸 가는 방법: [1] → 1가지
        arr[2]=2;   // 2칸 가는 방법: [1+1], [2] → 2가지

        // 점화식: arr[i] = arr[i-1] + arr[i-2]
        // i칸까지 가는 방법 = (i-1칸까지 가는 방법에서 +1칸) + (i-2칸까지 가는 방법에서 +2칸)
        for(int i=3; i<=n; i++){
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
        
        answer = arr[n];    // n칸까지 가는 경우의 수
      
        return answer;
    }
}