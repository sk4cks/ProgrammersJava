import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0, total = 0;
        int answer = 0;

        for(int i=0; i<queue1.length; i++){
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            sum1 += queue1[i];
            total += queue1[i]+queue2[i];
        }

        total /= 2;

        while (total != sum1){
            int value;

            if(total > sum1){
                value = que2.poll();
                que1.add(value);
                sum1 += value;
            }else{
                value = que1.poll();
                que2.add(value);
                sum1 -= value;
            }
            answer++;

            if(answer > queue1.length*3-3) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}