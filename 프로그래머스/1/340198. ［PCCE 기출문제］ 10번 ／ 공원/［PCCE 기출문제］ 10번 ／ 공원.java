import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 결과값 (설치 가능한 가장 큰 돗자리 한 변의 길이)
        int answer = -1;
        
        // 이전에 성공했던 돗자리 인덱스 (불필요한 작은 돗자리 재검사 방지용)
        int matsIndex = 0;

        // 돗자리 크기를 오름차순 정렬
        Arrays.sort(mats);

        // 공원의 모든 좌표를 탐색
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length; j++) {

                // 시작 지점이 빈 공간("-1")일 때만 검사
                if(park[i][j].equals("-1")){

                    // 돗자리 크기들을 작은 것부터 확인
                    Loop1 :
                    for(int k=matsIndex; k<mats.length; k++) {

                        // 현재 돗자리가 공원 범위를 벗어나면 더 큰 돗자리도 불가능 → 중단
                        if(i + mats[k] > park.length || j + mats[k] > park[i].length) 
                            break;

                        // 돗자리를 놓을 영역이 모두 "-1"인지 검사
                        for(int l=i; l<i + mats[k]; l++) {
                            for(int m=j; m<j + mats[k]; m++) {

                                // 중간에 하나라도 빈 공간이 아니면
                                // 이 좌표(i,j)에서는 더 이상 큰 돗자리도 불가능
                                if(!park[l][m].equals("-1")) 
                                    break Loop1;
                            }
                        }

                        // 여기까지 왔다는 것은 mats[k] 크기의 돗자리를 놓을 수 있다는 의미
                        matsIndex = k;     // 이후 탐색에서는 이보다 작은 돗자리는 볼 필요 없음
                        answer = mats[k];  // 가능한 돗자리 크기 갱신
                    }
                }
            }
        }

        // 최종적으로 설치 가능한 가장 큰 돗자리 크기 반환
        return answer;
    }
}