class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 배달, 수거 배열의 가장 끝 인덱스부터 시작
        int deliveryIndex = deliveries.length - 1;
        int pickupIndex = pickups.length - 1;
        
        while (true) {
            
            // 배달할 물량이 없는 집은 뒤에서부터 스킵
            while (deliveryIndex >= 0 && deliveries[deliveryIndex] == 0) {
                deliveryIndex--;
            }
            // 수거할 물량이 없는 집은 뒤에서부터 스킵
            while (pickupIndex >= 0 && pickups[pickupIndex] == 0) {
                pickupIndex--;
            }

            // 배달과 수거가 모두 끝났으면 종료
            if (deliveryIndex < 0 && pickupIndex < 0) {
                break;
            }

            // 이번 왕복에서 가야 할 가장 먼 거리 계산
            int dist = Math.max(deliveryIndex, pickupIndex);
            // 왕복 거리이므로 * 2, 집 번호는 1부터라 +1
            answer += 2 * (dist + 1);

            // 배달 처리 (용량 cap 만큼 뒤에서부터 처리)
            deliveryIndex = processHandling(cap, deliveryIndex, deliveries);
            // 수거 처리 (용량 cap 만큼 뒤에서부터 처리)
            pickupIndex = processHandling(cap, pickupIndex, pickups);
        }
        
        return answer;
    }
    
    
    /**
     * cap 용량만큼 물량을 처리하고
     * 아직 남은 가장 뒤쪽 인덱스를 반환
     */
    int processHandling(int cap, int index, int[] houses) {
        // 처리할 집이 남아있고, 용량이 남아있는 동안 반복
        while (index >= 0 && cap > 0) {
            
            // 현재 집에 처리할 물량이 없으면 다음 집으로 이동
            if (houses[index] == 0) {
                index--;
                
            } else {
                int count = Math.min(cap, houses[index]); // 현재 집에서 처리 가능한 최대 물량
                cap -= count;   // 용량 차감
                houses[index] -= count; // 집의 물량 차감

                // 해당 집의 물량이 모두 처리되었으면 다음 집으로 이동
                if (houses[index] == 0) {
                    index--;
                }
            }
        }

        // 아직 남아있는 가장 뒤쪽 인덱스 반환
        return index;
    }
}