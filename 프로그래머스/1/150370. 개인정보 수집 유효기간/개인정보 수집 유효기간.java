import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> tempArr = new ArrayList<>();
        
        for(int i=0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            for(int j=0; j<terms.length; j++){
                String[] term = terms[j].split(" ");
                
                if(privacy[1].equals(term[0])){
                    /*날짜비교*/
                    long betweenDate = getBetweenDate(today,privacy[0]);
                    long termMonth = Long.parseLong(term[1]);
                    
                    if(termMonth <= betweenDate){
                        tempArr.add(i+1);
                        break;
                    }
                }
            }
        }
        
        answer = new int[tempArr.size()];
        for(int i=0; i<tempArr.size(); i++){
            answer[i] = tempArr.get(i);
        }
        
        return answer;
    }
    
    public long getBetweenDate(String today, String privacyDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate newPrivacyDate = LocalDate.parse(privacyDate, formatter);
        LocalDate newToday = LocalDate.parse(today, formatter);
        
        return ChronoUnit.MONTHS.between(newPrivacyDate,newToday);
    }
}