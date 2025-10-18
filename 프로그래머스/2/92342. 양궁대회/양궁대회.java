class Solution {
    int maxDiff = 0;
    int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, info, new int[11]);
        
        return answer;
    }
    
    void dfs(int idx, int arrowsLeft, int[] apeach, int[] ryan) {
        // 모든 점수 구간 탐색 완료
        if (idx == 11 || arrowsLeft == 0) {
            ryan[10] += arrowsLeft; // 남은 화살은 0점 구간에 몰아줌
            checkScore(apeach, ryan);
            ryan[10] -= arrowsLeft;
            return;
        }

        // 1️⃣ 이 점수를 따기 위해 어피치보다 1발 더 쏘는 경우
        if (arrowsLeft > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            dfs(idx + 1, arrowsLeft - ryan[idx], apeach, ryan);
            ryan[idx] = 0;
        }

        // 2️⃣ 이 점수를 포기하는 경우
        dfs(idx + 1, arrowsLeft, apeach, ryan);
    }
    
    void checkScore(int[] apeach, int[] ryan) {
        int aScore = 0, rScore = 0;

        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            if (apeach[i] >= ryan[i]) aScore += 10 - i;
            else rScore += 10 - i;
        }

        int diff = rScore - aScore;
        if (diff <= 0) return;

        // 최대 점수 차 갱신
        if (diff > maxDiff || (diff == maxDiff && isBetter(ryan, answer))) {
            maxDiff = diff;
            answer = ryan.clone();
        }
    }
    
    // 낮은 점수에 더 많은 화살을 쏜 배열 선택
    boolean isBetter(int[] newR, int[] oldR) {
        for (int i = 10; i >= 0; i--) {
            if (newR[i] > oldR[i]) return true;
            else if (newR[i] < oldR[i]) return false;
        }
        return false;
    }
}