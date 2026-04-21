import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        // 각 공마다의 최소 거리 제곱을 담을 배열
        int[] answer = new int[balls.length];
        
        // 모든 목표 공에 대해 반복
        for (int i=0; i<balls.length; i++) {
            // 각 반사 경우의 거리 후보를 저장
            List<Integer> distList = new ArrayList<>();
            
            int[] target = balls[i];

            /*
             [거울 반사 좌표 생성]
             목표 공을 벽 기준으로 반사시킨 좌표들
             → 직선으로 쏘면 벽에 한 번 튕긴 효과
            */
            int[][] mirros = {
                {target[0], 2*n - target[1]}, // 윗벽 반사
                {2*m - target[0], target[1]}, // 오른쪽 벽 반사
                {target[0], -target[1]},      // 아래벽 반사
                {-target[0], target[1]}       // 왼쪽 벽 반사
            };

            /*
             [거리 계산]
             시작점 → 반사된 목표점까지의 직선 거리(제곱)
            */
            for (int[] mirror : mirros) {
                int dx = mirror[0] - startX;
                int dy = mirror[1] - startY;
                int dist = dx*dx + dy*dy; // 거리 제곱 (루트 생략)

                /*
                 [예외 1: 같은 x축 상에 있을 때]
                 시작점 → 목표 공 → 반사점 순서로 일직선이면
                 벽에 닿기 전에 목표 공을 먼저 맞게 되므로 제외
                */
                if (startX == target[0]) {
                    if ( (startY < target[1] && target[1] < mirror[1]) 
                        || (mirror[1] < target[1] && target[1] < startY)) {
                        continue;
                    }
                }

                /*
                 [예외 2: 같은 y축 상에 있을 때]
                 위와 동일한 이유로, 중간에 목표 공을 먼저 맞는 경우 제외
                */
                if (startY == target[1]) {
                    if ( (startX < target[0] && target[0] < mirror[0]) 
                        || (mirror[0] < target[0] && target[0] < startX)) {
                        continue;
                    }
                }

                // 유효한 거리만 후보에 추가
                distList.add(dist);
            }

            // 가장 짧은 거리 선택
            answer[i] = Collections.min(distList);
        }
        
        return answer;
    }
}