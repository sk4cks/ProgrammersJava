import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 각각의 문자열에서 2글자씩 끊어 만든 다중집합
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        // 교집합을 저장할 리스트
        List<String> intersection = new ArrayList<>();

        // 문자열을 다중집합 형태로 변환
        setList(list1,str1);
        setList(list2,str2);

        // ✅ 교집합(intersection) 구하기
        // list1의 원소를 하나씩 보면서, list2에도 존재하면 교집합에 추가
        // 중복을 고려해야 하므로 list2에서도 해당 원소를 제거함
        for(int i=list1.size()-1; i>=0; i--){
            String word = list1.get(i);
            
            // list2에 동일한 문자열이 존재할 경우
            if(list2.indexOf(word) != -1){
                intersection.add(word);         // 교집합에 추가
                list1.remove(i);                // list1에서 제거 (중복 방지)
                list2.remove(list2.indexOf(word));  // list2에서도 해당 원소 제거
            }
        }

        // ✅ 합집합(union) 크기 = 교집합 + 남은 list1 + 남은 list2
        int unionSize = intersection.size()+list1.size()+ list2.size();

        // ✅ 자카드 유사도 계산
        // J(A, B) = |A ∩ B| / |A ∪ B|
        // 단, 두 집합이 모두 공집합일 경우 유사도는 1로 정의 → 65536 반환
        if(intersection.size()==0 && unionSize==0) answer=65536;
        else answer = (int) ((intersection.size()/(double) unionSize)*65536);
        
        return answer;
    }
    
    /**
     * 문자열을 2글자씩 끊어서 다중집합 형태로 만드는 함수
     * - 오직 알파벳으로만 구성된 쌍만 포함 (대소문자 구분 X)
     */
    void setList(List<String> list, String str) {
        for(int i=0; i<str.length()-1; i++){
            
            // 현재 문자와 다음 문자를 이어서 2글자 단어 생성
            String word = 
                (String.valueOf(str.charAt(i))+str.charAt(i+1)).toLowerCase();
            
            // 두 글자가 모두 알파벳(a~z)인 경우에만 추가
            if(Pattern.matches("^[a-z]*$",word)) list.add(word);
        }
    }
}