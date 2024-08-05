import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<String> list = new ArrayList<>();
        Arrays.sort(book_time, Comparator.comparing(o -> o[0]));

        for(int i=0; i<book_time.length; i++){
            LocalTime time = LocalTime.parse(book_time[i][0],formatter);
            Optional<String> firstMatch = list.stream()
                    .filter(item -> ChronoUnit.MINUTES.between
                            (LocalTime.parse(item,formatter),time) >= 10)
                    .findFirst();

            if(firstMatch.orElse(null) !=null) {
                int index = list.indexOf(firstMatch.get());
                list.remove(index);
            }
            list.add(book_time[i][1]);
        }
        answer = list.size();
        
        return answer;
    }
}