import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    
    public String solution(String m, String[] musicinfos) {
        Map<String,Object> map = new HashMap<>(Map.of("title", "(None)", "time", 0L));
        String answer = "";
        m = melodyConvert(m);

        for(int i=0; i< musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            long diff = getDiffTime(arr[0], arr[1]);
            long defTime = (long) map.get("time");

            if(diff > defTime) {
                StringBuilder sb = new StringBuilder();
                String melody = melodyConvert(arr[3]);

                for(int j=0; j<diff; j++) {
                    sb.append(melody.charAt(j%melody.length()));
                }

                if(sb.toString().contains(m)) {
                    map.put("title", arr[2]);
                    map.put("time", diff);
                }
            }
        }

        answer = map.get("title").toString();
        
        return answer;
    }
    
    String melodyConvert(String str) {
        return str.replace("C#","c").replace("D#","d").replace("F#","f")
                .replace("G#","g").replace("A#","a").replace("B#","b");
    }
    
    long getDiffTime(String start, String end) {
        LocalTime startTime = LocalTime.parse(start,formatter);
        LocalTime endTime = LocalTime.parse(end,formatter);

        return ChronoUnit.MINUTES.between(startTime,endTime);
    }
    
}