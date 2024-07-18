import java.util.*;

class Solution {
    static String[] words = {"A","E","I","O","U"};
    static List<String> wordList = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        dfs("",0);
        for(int i=0; i<wordList.size(); i++){
            if(word.equals(wordList.get(i))){
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    void dfs (String word, int length) {
        wordList.add(word);
        if(length==5) return;
        for(int i=0; i< words.length; i++){
            dfs(word+words[i],length+1);
        }
    }
    
}