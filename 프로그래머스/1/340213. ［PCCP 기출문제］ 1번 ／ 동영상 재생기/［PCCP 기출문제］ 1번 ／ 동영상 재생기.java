import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Map<String,Integer> map = new HashMap<>();
        map.put("prev",-10);
        map.put("next",10);
        
        long videoTime = getTime(video_len);
        long posTime = getTime(pos);
        long startTime = getTime(op_start);
        long endTime = getTime(op_end);
        
        posTime = checkOpening(startTime, endTime, posTime);
        
        for(int i=0; i<commands.length; i++) {
            posTime += map.get(commands[i]);
            if(posTime < 0) posTime = 0;
            
            posTime = checkOpening(startTime, endTime, posTime);
            posTime = checkVideoTime(videoTime,posTime);
        }
        
        return String.format("%02d:%02d",posTime/60,posTime%60);
    }
    
    long getTime(String str) {
        String[] arr = str.split(":");
        
        return Long.parseLong(arr[0])*60 + Long.parseLong(arr[1]);
    }
    
    long checkOpening(long startTime, long endTime, long posTime) {
        if( startTime <= posTime  && posTime <= endTime) posTime = endTime;
        
        return posTime;
    }
    
    long checkVideoTime(long videoTime, long posTime) {
        if( videoTime < posTime ) posTime = videoTime;

        return posTime;
    }
    
}