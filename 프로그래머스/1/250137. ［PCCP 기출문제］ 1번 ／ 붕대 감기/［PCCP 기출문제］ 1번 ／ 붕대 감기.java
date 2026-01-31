class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 최대 체력 (회복 시 이 값을 넘지 못하도록 제한하기 위함)
        int maxHealth = health;
        
        // 마지막 공격 시간 (여기까지만 시뮬레이션 하면 됨)
        int length = attacks[attacks.length-1][0];
        
        // 연속 붕대 감기 성공 횟수
        int successCount = 0;
        
        // 현재 처리해야 할 공격 인덱스
        int targetIndex = 0;
        
        // 1초부터 마지막 공격 시간까지 1초씩 진행
        for(int i=1; i<=length; i++){
            
            // 현재 시간이 공격 시간과 같은 경우
            if(attacks[targetIndex][0] == i){
                
                // 공격을 받으면 연속 성공 카운트 초기화
                successCount = 0;
                
                // 공격 피해만큼 체력 감소
                health -= attacks[targetIndex][1];
                
                // 다음 공격으로 인덱스 이동
                targetIndex++;
                
                // 체력이 0 이하가 되면 즉시 종료 (사망)
                if(health <= 0) {
                    health = -1;
                    break;
                }
                
            }else{
                // 공격이 없는 시간 → 붕대 감기 진행
                
                // 연속 성공 카운트 증가
                successCount++;
                
                // 초당 회복량만큼 체력 회복
                health += bandage[1];
                
                // 연속 성공 시간이 붕대 시전 시간과 같아지면 추가 회복
                if(successCount == bandage[0]){
                    health += bandage[2];
                    successCount = 0;  // 추가 회복 후 카운트 초기화
                }
                
                // 체력이 최대 체력을 넘지 않도록 제한
                if(health > maxHealth) health = maxHealth;
            }
        }
        
        // 최종 체력 반환 (사망 시 -1)
        return health;
    }
}