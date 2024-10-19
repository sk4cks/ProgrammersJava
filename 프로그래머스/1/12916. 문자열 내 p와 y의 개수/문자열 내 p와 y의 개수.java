class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();

        long pCount = s.chars().filter(c -> c == 'P').count();
        long yCount = s.chars().filter(c -> c == 'Y').count();
        
        return pCount == yCount;
    }
}