class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryIndex = deliveries.length - 1;
        int pickupIndex = pickups.length - 1;
        
        while (true) {
            while (deliveryIndex >= 0 && deliveries[deliveryIndex] == 0) {
                deliveryIndex--;
            }
            while (pickupIndex >= 0 && pickups[pickupIndex] == 0) {
                pickupIndex--;
            }

            if (deliveryIndex < 0 && pickupIndex < 0) {
                break;
            }

            int dist = Math.max(deliveryIndex, pickupIndex);
            answer += 2 * (dist + 1);

            deliveryIndex = processHandling(cap, deliveryIndex, deliveries);
            pickupIndex = processHandling(cap, pickupIndex, pickups);
        }
        
        return answer;
    }
    
    
    int processHandling(int cap, int index, int[] houses) {
        while (index >= 0 && cap > 0) {
            
            if (houses[index] == 0) {
                index--;
                
            } else {
                int count = Math.min(cap, houses[index]);
                cap -= count;
                houses[index] -= count;

                if (houses[index] == 0) {
                    index--;
                }
            }
        }

        return index;
    }
}