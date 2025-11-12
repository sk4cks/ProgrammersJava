import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 최종적으로 출력할 메시지들을 담는 리스트
        List<String> list = new ArrayList<>();
        // 유저 아이디(uid)와 닉네임을 매핑하는 Map
        Map<String,String> nameMap = new HashMap<>();

        // 입장/퇴장 메시지 포맷을 저장하는 Map
        Map<String,String> map = new HashMap<>();
        map.put("Enter","%s님이 들어왔습니다.");
        map.put("Leave","%s님이 나갔습니다.");

        // 🔹 1단계: 최신 닉네임으로 nameMap 업데이트
        // record 배열의 각 문자열을 공백 기준으로 분리
        for(int i=0; i<record.length; i++) {
            String[] arr = record[i].split(" ");
            // "Enter uid 닉네임" 또는 "Change uid 닉네임" 인 경우만 닉네임 변경
            if(arr.length>2) nameMap.put(arr[1],arr[2]);
        }

        // 🔹 2단계: 메시지 생성
        // Enter / Leave 기록만 출력용 메시지로 변환
        for(int i=0; i<record.length; i++){
            String[] arr = record[i].split(" ");

            // Enter 또는 Leave 명령어인 경우에만 메시지 생성
            if(map.get(arr[0]) != null){
                // nameMap에서 uid에 해당하는 최신 닉네임을 불러와 메시지 구성
                list.add(String.format(map.get(arr[0]),nameMap.get(arr[1])));
            }
        }
        
        // 🔹 3단계: 리스트를 문자열 배열로 변환 후 반환
        return list.toArray(new String[0]);
    }
}