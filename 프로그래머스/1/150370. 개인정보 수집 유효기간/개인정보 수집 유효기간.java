import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        // 파기해야 할 개인정보 번호를 담을 리스트
        List<Integer> tempArr = new ArrayList<>();
        
        // 각 개인정보를 하나씩 확인
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" "); // [수집일자, 약관종류]
            
            // 약관 종류에 맞는 보관 기간 찾기
            for(int j=0; j<terms.length; j++){
                String[] term = terms[j].split(" "); // [약관종류, 유효기간(개월)]
                
                // 개인정보의 약관과 일치하는 약관을 찾았을 때
                if(privacy[1].equals(term[0])){
                    
                    // 오늘 날짜와 개인정보 수집일 사이의 개월 수 계산
                    long betweenDate = getBetweenDate(today, privacy[0]);
                    
                    // 해당 약관의 보관 가능 개월 수
                    long termMonth = Long.parseLong(term[1]);
                    
                    // 보관 기간 이상이 지났다면 파기 대상
                    if(termMonth <= betweenDate){
                        tempArr.add(i + 1); // 개인정보 번호는 1번부터 시작
                        break; // 더 이상 다른 약관 확인할 필요 없음
                    }
                }
            }
        }
        
        // List에 담긴 결과를 배열로 변환
        answer = new int[tempArr.size()];
        for(int i=0; i<tempArr.size(); i++){
            answer[i] = tempArr.get(i);
        }
        
        return answer;
    }
    
    // 두 날짜 사이의 개월 수를 계산하는 메서드
    public long getBetweenDate(String today, String privacyDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        
        // 문자열을 LocalDate로 변환
        LocalDate newPrivacyDate = LocalDate.parse(privacyDate, formatter);
        LocalDate newToday = LocalDate.parse(today, formatter);
        
        // 두 날짜 사이의 개월 수 차이 반환
        // (예: 2021.01.01 ~ 2021.03.01 -> 2개월)
        return ChronoUnit.MONTHS.between(newPrivacyDate, newToday);
    }
}