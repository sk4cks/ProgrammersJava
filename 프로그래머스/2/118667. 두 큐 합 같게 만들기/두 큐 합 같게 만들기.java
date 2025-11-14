import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 두 배열을 실제 큐로 변환
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        long sum1 = 0;     // que1의 현재 합
        long total = 0;    // 전체 합 (queue1 + queue2)
        int answer = 0;    // 이동 횟수

        // 초기 데이터 삽입 + 합 계산
        for(int i=0; i<queue1.length; i++){
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            sum1 += queue1[i];
            total += queue1[i]+queue2[i];
        }

        // 목표값(두 큐의 합을 동일하게 만드는 값) = 전체합 / 2
        total /= 2;

        // 두 큐의 합이 같아질 때까지 반복
        while (total != sum1){
            int value;

            // sum1 < total → que2에서 값을 빼서 que1으로 보내 sum1을 증가
            if (total > sum1){
                value = que2.poll();    // que2에서 맨 앞 값을 꺼냄
                que1.add(value);        // 그 값을 que1으로 이동
                sum1 += value;          // que1 합 업데이트
                
            // sum1 > total → que1에서 값을 빼서 que2로 보내 sum1을 감소
            } else {
                value = que1.poll();    // que1에서 맨 앞 값을 꺼냄
                que2.add(value);        // 그 값을 que2로 이동
                sum1 -= value;          // que1 합 업데이트
            }
            
            answer++;   // 이동 횟수 증가

            // 🔥 무한 루프 방지 조건
            // 최악의 경우 queue1.length * 3 - 3 번 이상 이동할 수 없다는 점을 이용
            if(answer > queue1.length*3-3) {
                answer = -1;    // 불가능 판정
                break;
            }
        }
        
        // sum1 == total 이면 answer 반환, 아니면 -1 반환
        return answer;
    }
}