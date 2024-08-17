import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        PriorityQueue<String[]> que = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        Arrays.sort(book_time, Comparator.comparing(o -> o[0]));

        for(int i=0; i<book_time.length; i++){
            if(que.isEmpty()){
                que.add(book_time[i]);
            }else{
                LocalTime time = LocalTime.parse(book_time[i][0],formatter);
                String[] arr = que.peek();
                long diff = ChronoUnit.MINUTES.between
                    (LocalTime.parse(arr[1],formatter),time);
                
                if( diff >= 10 ) que.poll();
                que.add(book_time[i]);
            }
        }
        answer = que.size();
        
        return answer;
    }
}