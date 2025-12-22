class Solution {
    public String solution(String p) {
        // 결과 문자열을 만들기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 1️⃣ 입력이 빈 문자열이면 그대로 반환
        if(p.isEmpty()) return "";

        // 2️⃣ 문자열 p를 균형잡힌 괄호 문자열 u, v로 분리
        int index = getSplitIndex(p);
        String u = p.substring(0,index);
        String v = p.substring(index);

        
        // 3️⃣ u가 올바른 괄호 문자열이면
        //    u + v에 대해 재귀적으로 변환한 결과 반환
        if(isBalanced(u)) return u + solution(v);
        
        // 4️⃣ u가 올바르지 않은 괄호 문자열인 경우
        else {
            // 4-1,2,3)
            // 새로운 문자열에 '('를 붙이고
            // v를 재귀적으로 변환한 뒤 ')를 붙임
            sb.append('(' + solution(v) + ')');
            
            // 4-4)
            // u의 첫 문자와 마지막 문자를 제거한 뒤
            // 나머지 문자의 괄호 방향을 뒤집어서 추가
            for(int i=1; i<u.length()-1; i++) {
                if(u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
        }

        // 변환이 완료된 문자열 반환
        return sb.toString();
    }
    
    // p를 가장 작은 균형잡힌 괄호 문자열 u와 나머지 v로 나누기 위한 인덱스 반환
    int getSplitIndex(String p) {
        int count = 0;
        int index = 0;

        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') count++;
            else count--;

            // '(' 와 ')' 개수가 같아지는 최초 지점
            if(count == 0) {
                index = i;
                break;
            }
        }

        // substring에서 사용하기 위해 +1 반환
        return index+1;
    }
    
    // u가 올바른 괄호 문자열인지 검사
    boolean isBalanced(String u) {
        boolean isValid = true;
        int count = 0;

        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(') count++;
            else count--;

            // 닫는 괄호가 먼저 나오면 올바르지 않음
            if(count < 0) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}