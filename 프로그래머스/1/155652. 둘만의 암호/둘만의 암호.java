class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // 문자열 s의 각 문자에 대해 처리
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);   // 현재 문자
            int copyIndex = index;  // 실제로 이동해야 할 횟수
            
            /*
             index 만큼 이동하되,
             skip에 포함된 문자를 만나면
             실제 이동 횟수를 1 증가시켜서
             건너뛰도록 처리
            */
            for(int j = 0; j < copyIndex; j++){
                
                c++;  // 알파벳 1칸 이동
                
                // 'z'(122)를 넘으면 'a'(97)로 순환
                if(c > 122) c = 97;
                
                // skip 문자열에 포함된 문자라면
                // 이동 횟수를 1 늘려서 건너뜀
                if(skip.indexOf(c) != -1) 
                    copyIndex++;
            }
            
            // 변환된 문자 추가
            answer += c;
        }
        
        return answer;
    }
}