import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        boolean[] visited = new boolean[cards.length];
        List<Integer> countList = new ArrayList<>();
        
        for(int i=0; i<cards.length; i++) {
            int curIndex = i;
            int count = 0;

            while (!visited[curIndex]) {
                count++;
                visited[curIndex] = true;
                curIndex = cards[curIndex]-1;
            }

            if(count > 0) {
                countList.add(count);
            }
        }
        
        if(countList.size() > 1) {
            countList.sort(Collections.reverseOrder());
            answer = countList.get(0) * countList.get(1);
        }
        
        return answer;
    }
}