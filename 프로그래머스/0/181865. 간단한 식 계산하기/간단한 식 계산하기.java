class Solution {
    public int solution(String binomial) {
        String[] strArr = binomial.split(" ");
        int prev = Integer.parseInt(strArr[0]);
        int next = Integer.parseInt(strArr[2]);
        
        switch(strArr[1]) {
            case "+":
                return prev + next;
            case "-":
                return prev - next;
            default:
                return prev * next;
        }
    }
}