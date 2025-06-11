class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for(int i=0; i<dic.length; i++) {
            if(dic[i].length() == spell.length) {
                for(int j=0; j<spell.length; j++) {
                    if(dic[i].indexOf(spell[j]) == -1) {
                        break;
                    }
                    if(j == spell.length-1) {
                        return 1;
                    }
                }
            }
        }
        
        return answer;
    }
}