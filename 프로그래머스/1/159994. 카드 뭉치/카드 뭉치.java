class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        // 기본값은 "Yes" (끝까지 문제없이 진행되면 유지)
        String answer = "Yes";
        
        // cards1, cards2 각각 현재 확인할 위치를 가리키는 인덱스
        int cards1Index = 0;
        int cards2Index = 0;
        
        // 목표 문장(goal)을 순서대로 확인
        for(int i=0; i<goal.length; i++){
            
            // cards1에서 아직 확인할 카드가 남아 있고
            // 현재 goal 단어가 cards1의 현재 위치 단어와 같다면
            if(cards1Index < cards1.length && goal[i].equals(cards1[cards1Index])){
                
                // cards1에서 한 장 사용 → 다음 카드로 이동
                cards1Index++;
                
            // cards2에서도 동일하게 검사
            }else if(cards2Index < cards2.length && goal[i].equals(cards2[cards2Index])){
                
                // cards2에서 한 장 사용 → 다음 카드로 이동
                cards2Index++;
                
            }else{
                // 둘 다 일치하지 않으면 목표 문장 생성 불가능
                return "No";
            }
        }
    
        // 모든 단어를 문제없이 만들었으면 "Yes"
        return answer;
    }
}