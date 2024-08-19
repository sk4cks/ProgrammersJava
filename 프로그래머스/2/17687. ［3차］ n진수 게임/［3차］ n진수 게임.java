class Solution {
    public String solution(int n, int t, int m, int p) {
        String[] hexArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int max = t*m;
        int start = 0;
        StringBuilder sb = new StringBuilder("0");
        StringBuilder answer = new StringBuilder();

        while (sb.length()<=max){
            int value = ++start;
            StringBuilder num = new StringBuilder();
            while (value > 0){
                int remain = value%n;
                num.insert(0, n>10 ? hexArr[remain] : remain);
                value /= n;
            }
            sb.append(num);
        }

        for(int i=p-1; i<max; i+=m) {
            answer.append(sb.charAt(i));
        }
        
        return answer.toString();
    }
}