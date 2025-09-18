class Solution {
    public int solution(int storey) {
        int answer = 0; // 버튼 누른 횟수를 누적할 변수
        
        while(storey > 0){ // storey가 0이 될 때까지 반복
            
           int remainder = storey%10; // 현재 자리(1의 자리)의 숫자 구하기
            
            // 현재 자리수가 5보다 크거나
            // 현재 자리수가 5일 때 → 다음 자리까지 확인해서
            //   - 다음 자리(10의 자리)가 5 이상이면 올림 처리 (위로 가는 게 더 유리)
            //   - 그렇지 않으면 내림 처리
           if(remainder > 5 ||
                   (remainder == 5 && ((storey/10)%10)+1 > 5)){
               
               // 10에서 remainder를 빼면 위로 올려야 하는 횟수
               int count = 10-remainder;
               
               answer+= count; // 버튼 누른 횟수 누적
               storey += count; // 올림 처리 (자리 올려주기)
               
           }else {
               // 그냥 내려가는 게 더 적은 경우
               answer += remainder; // 현재 자리만큼 버튼 누르기
           }
            
           storey /= 10; // 다음 자리(상위 자리)로 이동
        }
        
        return answer;
    }
}