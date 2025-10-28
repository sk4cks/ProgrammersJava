import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 🍰 right: 오른쪽 조각(동생)이 가진 토핑 종류 및 개수를 저장하는 맵
        Map<Integer,Integer> right = new HashMap<>();
        
        // 🍰 left: 왼쪽 조각(철수)이 가진 토핑 종류를 저장하는 집합 (중복 불가)
        Set<Integer> left = new HashSet<>();
        
        // 1️⃣ 처음에는 모든 토핑이 오른쪽(right)에 있음
        for(int i=0; i< topping.length;i++){
            right.put(topping[i],right.getOrDefault(topping[i],0)+1);
        }
        
        // 2️⃣ 한 칸씩 왼쪽으로 옮기면서 철수(left)와 동생(right)의 토핑 종류 개수 비교
        for(int i=0; i< topping.length; i++){
            
            // 현재 토핑을 철수 쪽으로 이동 (right → left)
            right.put(topping[i],right.get(topping[i])-1);
            left.add(topping[i]);   // 철수 쪽은 중복 상관없음 (종류만 중요)
            
            // 만약 right에서 해당 토핑이 0개가 되면, 종류에서 제거
            if(right.get(topping[i])==0) right.remove(topping[i]);
            
            // ✅ 철수(left)와 동생(right)의 토핑 ‘종류 수’가 같으면 공평한 컷
            if(left.size()== right.size()) answer++;
            
            // 🔻 왼쪽이 이미 오른쪽보다 종류가 많으면 이후는 더 불가능 → 종료
            else if(left.size() > right.size()) break;
        }
        
        // 공평하게 자를 수 있는 경우의 수 반환
        return answer;
    }
}