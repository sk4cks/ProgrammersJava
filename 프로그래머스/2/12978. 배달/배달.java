import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[][] arr = new int[N+1][N+1];
        int[] distArr = new int[N+1];
        Queue<int[]> que = new LinkedList<>();


        for(int i=0; i<road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int dist = road[i][2];

            if(arr[start][end] == 0 || arr[start][end] > dist) {
                arr[start][end] = dist;
                arr[end][start] = dist;
            }
        }

        que.add(new int[]{1,0});

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int index = poll[0];
            int dist = poll[1];

            for(int i=2; i<arr.length; i++) {
                if(arr[index][i] != 0) {
                    if(distArr[i] == 0 || distArr[i] > arr[index][i] + dist) {
                        distArr[i] = arr[index][i] + dist;
                        que.add(new int[]{i,distArr[i]});
                    }
                }
            }
        }

        for(int i=2; i<distArr.length; i++) {
            if(distArr[i] <= K) answer++;
        }

        return answer;
    }
}