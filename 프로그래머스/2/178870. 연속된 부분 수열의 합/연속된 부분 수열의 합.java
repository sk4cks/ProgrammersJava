class Solution {
    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int sum = 0;
        int[] answer = {0,N};
        for(int L=0,R=0;L< N;L++){
            while (R<N && sum<k){
                sum+=sequence[R++];
            }
            
            if(sum==k){
                int range = R-L-1;
                if(answer[1]-answer[0]>range){
                    answer[0] = L;
                    answer[1] = R-1;
                }
            }
            sum-=sequence[L];
        }
        return answer;
    }
}