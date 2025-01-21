class Solution {
    public int solution(int a, int b) {
        int aPlusB = Integer.parseInt(""+a+b);
        int bPlusA = Integer.parseInt(""+b+a);
        
        return aPlusB < bPlusA ? bPlusA : aPlusB;
    }
}