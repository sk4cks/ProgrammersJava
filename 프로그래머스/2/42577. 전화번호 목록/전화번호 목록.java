import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 1️⃣ 전화번호 목록을 사전순(오름차순)으로 정렬
        //    → 이렇게 하면, 접두어 관계인 번호들이 연속해서 나열됨
        Arrays.sort(phone_book);

        // 2️⃣ 인접한 두 번호만 비교하면 됨
        //    예: ["119", "1195524421", "97674223"] → "119"과 "1195524421"만 비교
        for(int i=0; i< phone_book.length-1; i++) {
            
            // 다음 번호(phone_book[i+1])가 현재 번호(phone_book[i])로 시작하는지 검사
            if(phone_book[i+1].startsWith(phone_book[i])){
                // 접두어 관계가 있으면 false 반환 (조건 불만족)
                return false;
            }
        }
        
        // 3️⃣ 끝까지 문제가 없으면 true 반환
        return answer;
    }
}