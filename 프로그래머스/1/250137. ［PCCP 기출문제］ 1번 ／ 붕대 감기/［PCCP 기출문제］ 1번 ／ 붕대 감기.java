class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int length = attacks[attacks.length-1][0];
        int successCount = 0;
        int targetIndex = 0;
        
        for(int i=1; i<=length; i++){
            if(attacks[targetIndex][0] == i){
                successCount = 0;
                health -= attacks[targetIndex][1];
                targetIndex++;
                if(health <=0) {
                    health = -1;
                    break;
                }
            }else{
                successCount++;
                health += bandage[1];
                if(successCount == bandage[0]){
                    health+=bandage[2];
                    successCount = 0;
                }
                if(health > maxHealth) health = maxHealth;
            }
        }
        return health;
    }
}