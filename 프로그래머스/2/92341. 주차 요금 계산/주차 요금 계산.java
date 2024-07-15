import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    
    public int[] solution(int[] fees, String[] records) {
        Map<String,String> map = new HashMap<>();
        Map<String,Integer> timeMap = new HashMap<>();

        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            if(record[2].equals("IN")) map.put(record[1],record[0]);
            else{
                String inTime = map.get(record[1]);
                timeMap.put(record[1],timeMap.getOrDefault(record[1],0)+getTime(inTime,record[0]));
                map.remove(record[1]);
            }
        }
        
        for(String key : map.keySet()){
            timeMap.put(key,timeMap.getOrDefault(key,0)+getTime(map.get(key),"23:59"));
        }

        List<String> carList = new ArrayList<>(timeMap.keySet());
        Collections.sort(carList);
        int[] answer = new int[carList.size()];

        for(int i=0; i<carList.size(); i++){
            int time = timeMap.get(carList.get(i));
            answer[i] = time<=fees[0] ? fees[1] : fees[1] + (int) Math.ceil((double) (time-fees[0])/fees[2]) * fees[3];
        }
        
        return answer;
    }
    
    static int getTime(String inTime, String outTime) {
        return (int) ChronoUnit.MINUTES.between(
                LocalTime.parse(inTime,formatter),
                LocalTime.parse(outTime,formatter));
    }
}