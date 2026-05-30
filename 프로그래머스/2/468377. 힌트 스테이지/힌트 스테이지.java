import java.util.*;

class Solution {

    /*
     * 다익스트라 탐색에 사용할 상태 정보
     */
    class State implements Comparable<State> {

        // 현재 진행 중인 스테이지
        int stage;

        // 현재까지 누적 비용
        int totalCost;

        /*
         * inventory[i]
         * = i번 스테이지에서 사용할 수 있는 힌트권 개수
         */
        int[] inventory;

        State(int stage, int totalCost, int[] inventory) {
            this.stage = stage;
            this.totalCost = totalCost;
            this.inventory = inventory;
        }

        /*
         * 누적 비용이 작은 상태를 우선 탐색
         */
        @Override
        public int compareTo(State o) {
            return this.totalCost - o.totalCost;
        }
    }

    public int solution(int[][] cost, int[][] hint) {

        int n = cost.length;

        /*
         * 다익스트라 우선순위 큐
         *
         * 누적 비용이 가장 작은 상태부터 탐색
         */
        PriorityQueue<State> pq = new PriorityQueue<>();

        /*
         * 초기 상태
         *
         * - 0번 스테이지 시작
         * - 누적 비용 0
         * - 보유 힌트권 없음
         */
        pq.add(new State(0, 0, new int[n + 1]));

        /*
         * 방문 상태 관리
         *
         * key:
         * 현재 스테이지 + 인벤토리 상태
         *
         * value:
         * 해당 상태까지 도달한 최소 비용
         */
        Map<String, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            /*
             * 모든 스테이지를 완료한 경우
             *
             * 다익스트라 특성상
             * 가장 먼저 도착한 비용이 최소 비용
             */
            if (cur.stage == n) {
                return cur.totalCost;
            }

            /*
             * 현재 상태를 문자열로 직렬화
             *
             * 예:
             * 2[0,1,0,2]
             */
            String stateKey =
                    cur.stage + Arrays.toString(cur.inventory);

            /*
             * 같은 상태를 더 적은 비용으로 방문한 적이 있으면
             * 현재 상태는 무시
             */
            if (visited.containsKey(stateKey)
                    && visited.get(stateKey) <= cur.totalCost) {
                continue;
            }

            visited.put(stateKey, cur.totalCost);

            /*
             * 현재 스테이지에서 사용할 수 있는 힌트권 개수
             */
            int currentHintCount =
                    cur.inventory[cur.stage + 1];

            /*
             * 힌트 사용 개수는 최대 n-1개
             *
             * cost[i][k]
             * = i번 스테이지에서
             * 힌트 k개 사용 시 비용
             */
            int useCount =
                    Math.min(currentHintCount, n - 1);

            int solveCost =
                    cost[cur.stage][useCount];

            /*
             * ------------------------------------------------
             * Case 1. 힌트 번들을 구매하지 않는 경우
             * ------------------------------------------------
             */

            int[] nextInvNoBundle =
                    cur.inventory.clone();

            // 현재 스테이지 힌트권 사용 완료
            nextInvNoBundle[cur.stage + 1] = 0;

            pq.add(
                    new State(
                            cur.stage + 1,
                            cur.totalCost + solveCost,
                            nextInvNoBundle
                    )
            );

            /*
             * ------------------------------------------------
             * Case 2. 힌트 번들을 구매하는 경우
             * ------------------------------------------------
             *
             * hint[i][0]
             * = 번들 가격
             *
             * hint[i][1] ~
             * = 힌트권을 지급할 스테이지 번호
             */
            if (cur.stage < n - 1) {

                int[] nextInvWithBundle =
                        cur.inventory.clone();

                // 현재 스테이지 힌트권 사용 완료
                nextInvWithBundle[cur.stage + 1] = 0;

                int bundlePrice =
                        hint[cur.stage][0];

                /*
                 * 번들에 포함된 힌트권 지급
                 */
                for (int j = 1; j < hint[cur.stage].length; j++) {

                    int targetStage =
                            hint[cur.stage][j];

                    nextInvWithBundle[targetStage]++;
                }

                pq.add(
                        new State(
                                cur.stage + 1,
                                cur.totalCost + solveCost + bundlePrice,
                                nextInvWithBundle
                        )
                );
            }
        }

        // 도달 불가능한 경우
        return -1;
    }
}