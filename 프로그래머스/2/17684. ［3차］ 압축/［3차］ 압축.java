import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        // 사전 (초기에는 A~Z까지 채워짐)
        List<String> dictionary = new ArrayList<>();
        
        // 결과를 담을 리스트 (사전 인덱스 번호)
        List<Integer> answer = new ArrayList<>();
        
        // 입력 문자열을 가변적으로 다루기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder(msg);

        // 1. 사전을 초기화 (A=1, B=2, ..., Z=26)
        for(int i=0; i<26; i++) {
            dictionary.add(String.valueOf((char) ('A'+i)));
        }

        // 2. msg를 다 소진할 때까지 반복
        while (sb.length() > 0) {
            
            // 사전에 있는 가장 긴 문자열을 찾기 위해
            // 뒤에서부터 탐색 (사전에 추가된 긴 문자열이 뒤에 있음)
            for(int i = dictionary.size()-1; i>=0; i--) {
                
                // 현재 문자열이 dictionary[i]로 시작하면 (가장 긴 문자열 발견)
                if(sb.toString().startsWith(dictionary.get(i))) {
                    
                    // 해당 문자열의 인덱스(i+1)를 결과에 추가
                    answer.add(i+1);
                    
                    // 사전에 새로운 문자열 추가:
                    // 발견된 문자열 + 그 다음 글자 1개
                    dictionary.add(sb.substring(0,Math.min(dictionary.get(i).length()+1,sb.length())));
                    
                    // 입력 문자열에서 사용한 부분 제거
                    sb.delete(0,dictionary.get(i).length());
                    
                    // 찾았으니 내부 for문 탈출 → 다시 while 반복
                    break;
                }
            }
        }
        
        // 결과 리스트를 int[]로 변환 후 반환
        return answer.stream().mapToInt(i->i).toArray();
    }
}