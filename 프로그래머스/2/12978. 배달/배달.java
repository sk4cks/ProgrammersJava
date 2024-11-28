import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[][] arr = new int[N+1][N+1];  // arr[start][end] = 시작마을에서 도착마을까지의 거리
        int[] distArr = new int[N+1]; //1번마을에서 n번째 마을까지의 거리 배열
        Queue<int[]> que = new LinkedList<>();


        for(int i=0; i<road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int dist = road[i][2];

            //시작마을에서 도착마을까지의 거리중 최소값을 넣어준다
            if(arr[start][end] == 0 || arr[start][end] > dist) {
                arr[start][end] = dist;
                arr[end][start] = dist;
            }
        }

        //1번마을에서 거리0으로 스타트
        que.add(new int[]{1,0});

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int index = poll[0]; //시작마을 번호
            int dist = poll[1]; //현재까지의 거리

            //arr의 행,열 값이 같기때문에 arr[시작마을][i] for
            for(int i=2; i<arr.length; i++) { 
                if(arr[index][i] != 0) { //MAX값으로 초기화를 안해줬기때문에 0이면 갈수 없는 마을
                    
                    //distArr[i]가 0인경우는 첨 방문한 마을 
                    //또는 이미 방문 했었는데 더 짧은 거리가 있는 경우 
                    if(distArr[i] == 0 || distArr[i] > arr[index][i] + dist) {
                        distArr[i] = arr[index][i] + dist;
                        que.add(new int[]{i,distArr[i]});
                    }
                }
            }
        }

        //1번마을에서 n번째 마을까지의 거리 배열에서 K시간 이하 걸리는 마을 카운트
        for(int i=2; i<distArr.length; i++) {
            if(distArr[i] <= K) answer++;
        }

        return answer;
    }
}