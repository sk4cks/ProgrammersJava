class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 공원의 세로, 가로 크기
        int h = park.length;
        int w = park[0].length();
        
        // 시작 위치 (S의 좌표)
        int startRow = 0;
        int startCol = 0;
        
        int[] answer = new int[2];
        
        // 문자열 공원을 2차원 배열로 변환하여 사용
        String[][] realPark = new String[h][w];

        // 공원 정보 세팅 및 시작 위치 찾기
        for(int i=0; i< h; i++){
            String[] division = park[i].split("");
            for(int j=0; j< division.length; j++){
                realPark[i][j] = division[j];
                
                // 시작 지점 'S' 좌표 저장
                if(division[j].equals("S")){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        
        // 주어진 이동 경로(routes) 순서대로 수행
        for(int i=0; i< routes.length; i++){
            String[] division = routes[i].split(" ");
            
            // 현재 위치를 백업 (이동 실패 시 되돌리기 위함)
            int baseRow = startRow;
            int baseCol = startCol;
            
            int length = Integer.parseInt(division[1]);  // 이동 거리
            
            // 한 칸씩 이동하며 경로 검증
            for(int j=0; j<length; j++){
                switch (division[0]){
                    case "E":  // 동쪽
                        startCol++;
                        break;
                    case "W":  // 서쪽
                        startCol--;
                        break;
                    case "S":  // 남쪽
                        startRow++;
                        break;
                    case "N":  // 북쪽
                        startRow--;
                        break;
                }

                try{
                    // 이동한 좌표가 유효한지 확인
                    String s = realPark[startRow][startCol];
                    
                    // 장애물(X)을 만나면 예외 발생시켜 이동 실패 처리
                    if(s.equals("X")){
                        throw new RuntimeException();
                    }
                }catch (RuntimeException e){
                    // 범위를 벗어나거나(X 포함) 예외 발생 시
                    // 해당 이동 전체를 무효화하고 원래 위치로 복귀
                    startRow = baseRow;
                    startCol = baseCol;
                    break;
                }
            }
        }

        // 최종 위치 반환
        answer[0] = startRow;
        answer[1] = startCol;
        
        return answer;
    }
}