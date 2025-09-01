class Solution {
    public int[] solution(long begin, long end) {
        int size = (int) (end - begin) + 1;
        int[] answer = new int[size];

        for(long i=begin; i<=end; i++) {
            answer[(int) (i-begin)] = getBlock((int)i);
        }
        
        return answer;
    }
    
    int getBlock(int i) {
        if(i == 1) return 0;
        
        int result = 1;

        //약수 찾는 for
        for(int j=2; j*j<=i; j++) {
            if(i%j == 0) {
                if(i/j <= 10000000) {
                    result = i/j;
                    break;
                } else {
                    result = j;
                }
            }
        }

        return result;
    }
    
}