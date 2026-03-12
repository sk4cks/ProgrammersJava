import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        
        // 포켓몬 종류를 저장할 Set (중복 자동 제거)
        HashSet<Integer> set = new HashSet<>();
        
        // 모든 포켓몬을 Set에 추가 → 중복 제거
        for(int num : nums){
            set.add(num);
        }
        
        // 선택 가능한 포켓몬 수 (전체의 절반)
        int maxPick = nums.length / 2;
        
        // 포켓몬 종류 수
        int typeCount = set.size();
        
        // 둘 중 작은 값이 최대 선택 가능한 서로 다른 종류 수
        return Math.min(maxPick, typeCount);
    }
}