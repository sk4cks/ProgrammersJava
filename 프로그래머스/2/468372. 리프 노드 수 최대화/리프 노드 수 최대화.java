class Solution {
    int answer = 1;
	
	public int solution(int dist_limit, int split_limit) {
		dfs(1, 1, 1, 0, dist_limit, split_limit);
        
        return answer;
    }
	
	void dfs(long active, long used, long split, long leaf, int dist_limit, int split_limit) {
        if (used > dist_limit) return;

        answer = (int) Math.max(leaf + active, answer);

        for (int child = 2; child <= 3; child++) {
            long nextSplit = split * child;

            if (nextSplit <= split_limit) {
                long nextNode = active * child;

                long remain = dist_limit - used;

                long nextActive = Math.min(nextNode, remain);

                long nextLeaf = leaf + nextNode - nextActive;

                dfs(nextActive, used + nextActive, nextSplit, nextLeaf, dist_limit, split_limit);
            }
        }
    }
}