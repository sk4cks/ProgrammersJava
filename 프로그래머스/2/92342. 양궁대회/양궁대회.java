import java.util.*;

class Solution {
    static final int SIZE = 11; // 점수 개수 (10점 ~ 0점)

    int maxDiff = 0;
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        dfs(0, n, info, new int[SIZE]);
        return answer;
    }

    // dfs(현재 점수 인덱스, 남은 화살 수, 어피치, 라이언)
    void dfs(int scoreIdx, int arrows, int[] apeach, int[] ryan) {

        // 종료 조건: 마지막 점수 or 화살 소진
        if (scoreIdx == SIZE || arrows == 0) {
            ryan[SIZE - 1] += arrows; // 남은 화살은 0점에 몰아줌
            evaluate(apeach, ryan);
            ryan[SIZE - 1] -= arrows; // 원복 (백트래킹)
            return;
        }

        // 1. 해당 점수를 이기는 경우
        if (arrows > apeach[scoreIdx]) {
            ryan[scoreIdx] = apeach[scoreIdx] + 1;
            dfs(scoreIdx + 1, arrows - ryan[scoreIdx], apeach, ryan);
            ryan[scoreIdx] = 0; // 원복
        }

        // 2. 해당 점수를 포기하는 경우
        dfs(scoreIdx + 1, arrows, apeach, ryan);
    }

    // 점수 계산 및 결과 갱신
    void evaluate(int[] apeach, int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < SIZE; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;

            if (ryan[i] > apeach[i]) {
                ryanScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }

        int diff = ryanScore - apeachScore;

        // 라이언이 못 이기면 무시
        if (diff <= 0) return;

        // 더 큰 점수차 or 동일 점수차 + 낮은 점수 더 많이 맞힘
        if (diff > maxDiff || (diff == maxDiff && isBetter(ryan, answer))) {
            maxDiff = diff;
            answer = ryan.clone();
        }
    }

    // 낮은 점수를 더 많이 맞힌 경우 우선
    boolean isBetter(int[] current, int[] best) {
        for (int i = SIZE - 1; i >= 0; i--) {
            if (current[i] > best[i]) return true;
            if (current[i] < best[i]) return false;
        }
        return false;
    }
}