class Solution {
    
    // 결과를 저장할 배열, index 0은 0의 개수, index 1은 1의 개수
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        // 전체 배열을 압축 시작 (x=0, y=0부터, 배열 크기만큼)
        compress(0,0,arr.length,arr);
        
        return answer;
    }
    
    // x, y : 현재 확인할 배열의 시작 좌표
    // length : 현재 확인할 배열의 크기
    // arr : 원본 2차원 배열
    void compress(int x, int y, int length, int[][] arr) {
        int value = arr[x][y];  // 현재 블록의 기준 값
        boolean isPressed = true;   // 모든 값이 같은지 체크하는 플래그

        Loop:
        for(int i=x; i<x+length; i++) {
            for(int j=y; j<y+length; j++) {
                // 만약 하나라도 기준 값과 다르면
                if(arr[i][j] != value) {
                    isPressed = false;  // 같은 값으로 압축 불가
                    break Loop; // 바로 모든 반복문 탈출
                }
            }
        }

        // 모든 값이 같으면
        if(isPressed) {
            answer[value]++;    // 해당 값의 개수 1 증가
            
        // 값이 다르면 배열을 4등분하여 재귀 호출
        } else {
            int k = length/2;
            compress(x,y,k,arr);    // 왼쪽 위
            compress(x,y+k,k,arr);  // 오른쪽 위
            compress(x+k,y,k,arr);  // 왼쪽 아래
            compress(x+k,y+k,k,arr);    // 오른쪽 아래
        }
    }
}