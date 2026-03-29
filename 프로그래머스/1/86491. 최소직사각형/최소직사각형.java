class Solution {
    public int solution(int[][] sizes) {
        
        // 최종 지갑 크기 (가로 최대, 세로 최대)를 저장할 배열
        int answer = 0;
        int[] rectangle = new int[2];

        // 모든 명함을 순회
        for(int i=0; i<sizes.length; i++){
            
            // 명함을 회전 가능하므로
            // 항상 큰 값을 가로(width), 작은 값을 세로(height)로 맞춤
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);

            // 지금까지 본 명함 중 가장 큰 가로 길이 갱신
            rectangle[0] = Math.max(width, rectangle[0]);
            
            // 지금까지 본 명함 중 가장 큰 세로 길이 갱신
            rectangle[1] = Math.max(height, rectangle[1]);
        }
        
        // 최종 지갑 크기 = 가로 최대 × 세로 최대
        answer = rectangle[0] * rectangle[1];
        
        return answer;
    }
}