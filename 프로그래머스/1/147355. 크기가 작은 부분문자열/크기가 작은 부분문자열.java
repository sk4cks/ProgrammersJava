class Solution {
    public int solution(String t, String p) {
        long pValue = Long.valueOf(p);
        int answer = 0;

        for(int i=0; i<t.length()-p.length()+1; i++){
            String tmp = t.substring(i,i+p.length());
            if(Long.valueOf(tmp) <= pValue) answer++;
        }
        return answer;
    }
}