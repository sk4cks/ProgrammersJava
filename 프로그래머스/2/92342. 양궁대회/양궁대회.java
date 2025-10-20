import java.util.*;

class Solution {
    int maxDiff = 0;        // 최대 점수 차이
    int[] answer = {-1};    // 라이언이 못이기는 경우 리턴 기본값
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, info, new int[11]);
        
        return answer;
    }
    
    // dfs(인덱스, 남은화살, 어피치배열, 라이언배열)
    void dfs(int idx, int cnt, int[] apeachArr, int[] ryanArr) {
        
        // 마지막일경우 0점에 남은화살을 넣고 점수체크
        if (idx == 11 || cnt == 0) {
            ryanArr[10] += cnt;
            checkScore(apeachArr, ryanArr);
            ryanArr[10] -= cnt;     // 백트래킹을 위한 원복
            return;
        }

        // 라이언이 점수를 가져올때
        if (cnt > apeachArr[idx]) {
            ryanArr[idx] = apeachArr[idx] + 1;
            dfs(idx + 1, cnt - (apeachArr[idx] + 1), apeachArr, ryanArr);
            ryanArr[idx] = 0;   // 백트래킹을 위한 원복
        }

        // 라이언이 점수를 포기할때
        dfs(idx + 1, cnt, apeachArr, ryanArr);
    }
    
    // 점수체크
    void checkScore(int[] apeachArr, int[] ryanArr) {
        int apeachScore = 0;
        int ryanScore = 0;
        int diff = 0;

        for (int i=0; i<apeachArr.length; i++) {
            if (apeachArr[i] > 0 || ryanArr[i] > 0) {   // 둘다 0발이 아닌경우에만
                if (ryanArr[i] > apeachArr[i]) {
                    ryanScore += 10 - i;
                } else {
                    apeachScore += 10 - i;
                }
            }
        }

        diff = ryanScore - apeachScore;
        if (diff <= 0) return;

        // 점수차이가 크거나 || (점수차이가 같은데 낮은 점수에 더 많이 쐈을때)
        if (diff > maxDiff || (diff == maxDiff && checkLowerScore(answer, ryanArr))) {
            maxDiff = diff;
            answer = ryanArr.clone();
        }
    }

    // 가장 낮은 점수를 더 맞힌경우 체크
    boolean checkLowerScore(int[] oldArr, int[] newArr) {
        for (int i=oldArr.length-1; i>=0; i--) {
            if (oldArr[i] < newArr[i]) return true;
            else if (oldArr[i] > newArr[i]) return false;
        }

        return false;
    }
    
}