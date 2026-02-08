class Solution {
    public int[] solution(String[] wallpaper) {
        // answer: [최소 행, 최소 열, 최대 행, 최대 열]
        // 최소값은 크게, 최대값은 작게 초기화
        int[] answer = {99999, 99999, 0, 0};
        
        // 벽지의 모든 좌표를 탐색
        for(int i=0; i<wallpaper.length; i++){
            String[] split = wallpaper[i].split("");
            
            for(int j=0; j< split.length; j++){
                
                // 파일이 있는 위치('#')를 찾으면
                if(split[j].equals("#")){
                    
                    // 최소 행 갱신
                    answer[0] = answer[0] > i ? i : answer[0];
                    
                    // 최소 열 갱신
                    answer[1] = answer[1] > j ? j : answer[1];
                    
                    // 최대 행 갱신 (드래그는 끝 좌표 +1 이므로 i+1)
                    answer[2] = answer[2] < i+1 ? i+1 : answer[2];
                    
                    // 최대 열 갱신 (드래그는 끝 좌표 +1 이므로 j+1)
                    answer[3] = answer[3] < j+1 ? j+1 : answer[3];
                }
            }
        }
        
        // 파일들을 모두 포함하는 최소 드래그 영역 반환
        return answer;
    }
}