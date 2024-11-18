class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            switch (n%3) {
                case 0:
                    sb.insert(0,4);
                    n = n/3-1;
                    break;
                default:
                    sb.insert(0,n%3);
                    n /= 3;
                    break;
            }
        }
        
        return sb.toString();
    }
}