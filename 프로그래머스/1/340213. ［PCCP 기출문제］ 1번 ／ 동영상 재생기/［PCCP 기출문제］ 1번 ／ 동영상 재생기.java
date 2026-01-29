import java.util.*;

class Solution {
    public String solution(String video_len, String pos,
                           String op_start, String op_end,
                           String[] commands) {

        // 명령어에 따른 이동 시간 (초)
        Map<String, Integer> map = new HashMap<>();
        map.put("prev", -10);  // 10초 뒤로
        map.put("next", 10);   // 10초 앞으로

        // 문자열 시간을 초(second) 단위로 변환
        long videoTime = getTime(video_len); // 전체 영상 길이
        long posTime = getTime(pos);         // 현재 위치
        long startTime = getTime(op_start);  // 오프닝 시작
        long endTime = getTime(op_end);      // 오프닝 끝

        // 시작 위치가 오프닝 구간에 있다면 오프닝 끝으로 이동
        posTime = checkOpening(startTime, endTime, posTime);

        // 명령어들을 순서대로 처리
        for (int i = 0; i < commands.length; i++) {

            // prev / next에 따라 시간 이동
            posTime += map.get(commands[i]);

            // 0초 미만으로 내려가면 0으로 보정
            if (posTime < 0) posTime = 0;

            // 이동 후 오프닝 구간이면 자동 스킵
            posTime = checkOpening(startTime, endTime, posTime);

            // 영상 길이를 초과하면 영상 끝으로 보정
            posTime = checkVideoTime(videoTime, posTime);
        }

        // 다시 mm:ss 형식으로 변환하여 반환
        return String.format("%02d:%02d", posTime / 60, posTime % 60);
    }

    // "mm:ss" 문자열을 초(second)로 변환
    long getTime(String str) {
        String[] arr = str.split(":");
        return Long.parseLong(arr[0]) * 60 + Long.parseLong(arr[1]);
    }

    // 현재 위치가 오프닝 구간에 있다면 오프닝 끝으로 이동
    long checkOpening(long startTime, long endTime, long posTime) {
        if (startTime <= posTime && posTime <= endTime) {
            posTime = endTime;
        }
        return posTime;
    }

    // 영상 길이를 초과하면 영상 끝으로 이동
    long checkVideoTime(long videoTime, long posTime) {
        if (videoTime < posTime) {
            posTime = videoTime;
        }
        return posTime;
    }
}