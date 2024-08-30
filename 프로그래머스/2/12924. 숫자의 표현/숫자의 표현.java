class Solution {
    public int solution(int n) {
        int max = n/2;
        int answer = 1;

        for(int i=1; i<=max; i++){
            int value = i;
            int subIndex = value;
            while (value<n){
                value+= ++subIndex;
                if(value==n){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}