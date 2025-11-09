import java.util.*;

class Solution {
    
    // 🔸 사용할 모음 문자 배열
    static String[] words = {"A","E","I","O","U"};
    // 🔸 가능한 모든 단어를 저장할 리스트
    static List<String> wordList = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("",0);  // 🔹 DFS(깊이 우선 탐색)로 가능한 모든 조합 생성
        
        // 🔹 생성된 단어 리스트에서 입력 단어의 인덱스(순서) 찾기
        for(int i=0; i<wordList.size(); i++){
            if(word.equals(wordList.get(i))){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    // 🔸 DFS를 이용하여 길이 0~5까지 가능한 모든 단어 생성
    void dfs (String word, int length) {
        wordList.add(word); // 현재 단어를 리스트에 추가
        
        if(length==5) return;   // 최대 길이 5 초과 시 탐색 종료
        
        // 🔹 5개의 모음을 하나씩 붙여서 재귀 호출
        for(int i=0; i< words.length; i++){
            dfs(word+words[i],length+1);
        }
    }
    
}