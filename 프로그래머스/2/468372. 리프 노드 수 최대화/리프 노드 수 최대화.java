class Solution {
    int answer = 1;
	
	public int solution(int dist_limit, int split_limit) {
		dfs(1, 1, 1, 0, dist_limit, split_limit);
        
        return answer;
    }
	
	//active: 분배가능한 활성화 상태의 노드 수
    //used: 사용한 노드 수
    //split: 현재까지 분배도
    //leaf: 분배 불가한 확정된 leaf노드의 수
    void dfs(long active, long used, long split, long leaf, int dist_limit, int split_limit) {
        if (used > dist_limit) {
            return;
        }
        
        // (현재 활성화 상태 노드 수 + 확정된 leaf 노드 수) 또는 answer 중 최대값
        answer = (int) Math.max(active + leaf, answer);

        // 자식개수는 2 또는 3
        for (int child = 2; child <= 3; child++) {
            long nextSplit = child * split;

            if (nextSplit <= split_limit) {
                long nextNode = active * child; // 분배 가능한 노드 수 * 자식 수
                long remain = dist_limit - used; // 사용가능한 남은 노드 수

                long nextActive = Math.min(nextNode, remain); // 다음번 분배가능한 노드 수
                long nextLeaf = leaf + nextNode - nextActive; // leaf + 탈락된 노드 수

                dfs(nextActive, used + nextActive, nextSplit, nextLeaf, dist_limit, split_limit);
            }
        }
    }
}