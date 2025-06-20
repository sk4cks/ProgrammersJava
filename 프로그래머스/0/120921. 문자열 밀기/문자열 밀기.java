class Solution {
    public int solution(String A, String B) {
        String copy = A;
        int answer = 0;

        for(int i=0; i<A.length(); i++) {
            if(copy.equals(B)) {
                return answer;
            }

            copy = copy.charAt(copy.length()-1) + copy.substring(0,copy.length()-1);
            answer++;
        }
        
        return -1;
    }
}