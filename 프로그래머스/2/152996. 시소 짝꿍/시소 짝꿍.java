import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;        // 가능한 짝꿍 쌍의 개수를 저장할 변수
        
        Arrays.sort(weights);   // 정렬 (작은 무게부터 순차적으로 처리하기 위함)
        Map<Long, Integer> map = new HashMap<>();   // 지금까지 나온 무게별 개수를 저장하는 해시맵 (누적 카운트)
        
        for(int i : weights) {
            long weight = (long) i; // 현재 무게 (int → long 변환, 곱셈 시 overflow 방지)
            
            // 1️⃣ 같은 무게 (1:1 비율)
            // 지금까지 동일한 weight가 나온 적이 있다면 짝꿍 가능
            if (map.containsKey(weight)) answer += map.get(weight);
            
            // 2️⃣ 2:3 비율
            // weight * 2가 3으로 나누어떨어질 때만 정수 짝꿍이 존재
            if ((weight * 2) % 3 == 0) {
                long b = (weight * 2) / 3;
                if(map.containsKey(b)) answer += map.get(b);
            }
            
            // 3️⃣ 1:2 비율
            // weight가 짝수일 때만 정수 짝꿍이 존재
            if (weight % 2 == 0) {
                long c = weight / 2;
                if(map.containsKey(c)) answer += map.get(c);
            }
            
            // 4️⃣ 3:4 비율
            // weight * 3이 4로 나누어떨어질 때만 정수 짝꿍이 존재
            if ((weight * 3) % 4 == 0) {
                long d = (weight * 3) / 4;
                if(map.containsKey(d)) answer += map.get(d);
            }
            
            // 현재 무게를 해시맵에 등록 (이제 다음 사람들과 비교할 수 있도록)
            map.put(weight, map.getOrDefault(weight, 0)+1);
        }
        
        return answer;  // 최종적으로 가능한 짝꿍 쌍의 총 개수 반환
    }
}