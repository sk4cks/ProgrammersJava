import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // 시간 파싱용 포맷터 (문자열 "HH:mm" → LocalTime 변환)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        // 종료시간 기준으로 정렬되는 우선순위 큐 (현재 사용 중인 방들을 관리)
        PriorityQueue<String[]> que = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        
        // 예약 시작시간 기준으로 정렬 (먼저 들어오는 예약부터 처리)
        Arrays.sort(book_time, Comparator.comparing(o -> o[0]));

         // 예약 순서대로 처리
        for(int i=0; i<book_time.length; i++){
            if(que.isEmpty()){ // 방이 하나도 없으면 새로 배정
                que.add(book_time[i]);
                
            }else{
                // 현재 예약의 시작 시간
                LocalTime time = LocalTime.parse(book_time[i][0],formatter);
                
                 // 가장 빨리 끝나는 예약 확인 (큐의 맨 앞)
                String[] arr = que.peek();
                
                // 가장 빨리 끝나는 방의 종료 시간과 현재 예약 시작 시간 차이 (분 단위)
                long diff = ChronoUnit.MINUTES.between
                    (LocalTime.parse(arr[1],formatter),time);
                
                 // 만약 차이가 10분 이상이면 → 청소 끝난 뒤 재사용 가능 → 기존 방 빼고 새 예약 배정
                if( diff >= 10 ) que.poll();
                
                // 현재 예약을 큐에 넣기
                que.add(book_time[i]);
            }
        }
        
        // 큐에 남아 있는 방 개수가 필요한 최소 객실 수
        answer = que.size();
        
        return answer;
    }
}