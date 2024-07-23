class Solution {
    public int solution(String[] babbling) {
        String[] list = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++){
            String s = babbling[i];
            for(int j=0; j< list.length; j++){
                if(s.indexOf(list[j]+list[j]) != -1) break;
                s = s.replaceAll(list[j]," ");
            }
            s = s.replaceAll(" ","");
            if(s.equals("")) answer++;
        }
        return answer;
    }
}