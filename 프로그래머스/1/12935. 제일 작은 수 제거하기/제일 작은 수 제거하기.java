class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        
        // 최솟값 찾기
        for(int n : arr) min = Math.min(min, n);
        
        // 개수 세기
        int count = 0;
        for(int n : arr) if(n != min) count++;
        
        if(count == 0) return new int[]{-1};
        
        int[] answer = new int[count];
        int idx = 0;
        
        for(int n : arr){
            if(n != min) answer[idx++] = n;
        }
        
        return answer;
    }
}