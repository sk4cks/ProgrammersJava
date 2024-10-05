class Solution {
    public boolean solution(int x) {
        int copxX = x;
        int total = 0;

        while ( copxX > 0) {
            total += copxX % 10;
            copxX /= 10;
        }
        
        return x % total == 0 ;
    }
}