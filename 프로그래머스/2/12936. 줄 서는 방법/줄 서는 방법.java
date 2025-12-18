import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>(); // 아직 사용하지 않은 숫자들을 담을 리스트 (1 ~ n)
        int[] answer = new int[n];  // 결과 순열을 저장할 배열
        long factorial = 1; // (n!) 값을 저장할 변수
        int idx = 0;    // answer 배열에 값을 넣을 위치 인덱스
        k--;    // k를 0-based index로 맞추기 위해 1 감소
        
        // 1 ~ n 까지 리스트에 넣고 n! 계산
        for(int i=1; i<=n; i++) {
            factorial *= i;
            list.add(i);
        }

        // 모든 숫자를 사용할 때까지 반복
        while (!list.isEmpty()) {
            factorial /= n--;   // 현재 자리에서 사용할 (n-1)! 계산
            int index = (int) (k / factorial);  // k번째 순열에서 현재 자리에 올 숫자의 인덱스
            answer[idx++] = list.get(index);    // 해당 인덱스의 숫자를 결과에 저장
            list.remove(index); // 사용한 숫자는 리스트에서 제거
            k %= factorial; // 다음 자리를 위해 k 값을 갱신
        }
        
        return answer;  // 완성된 k번째 순열 반환
    }
}