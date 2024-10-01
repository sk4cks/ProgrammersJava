class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<arr1.length; i++){
            StringBuilder sb = new StringBuilder();
            String str1 = lpad(Integer.toString(arr1[i],2),n,'0');
            String str2 = lpad(Integer.toString(arr2[i],2),n,'0');

            for(int j=0; j<str1.length(); j++){
                char chr1 = str1.charAt(j);
                char chr2 = str2.charAt(j);

                if(chr1=='0' && chr2=='0') sb.append(" ");
                else sb.append("#");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    String lpad(String input, int length, char padChar) {
        // 현재 문자열의 길이가 요구하는 길이보다 짧을 때만 패딩
        if (input.length() >= length) {
            return input;
        }

        // 패딩할 문자의 개수 계산
        int padLength = length - input.length();

        // 패딩 문자로 원하는 길이만큼 채우기
        StringBuilder padded = new StringBuilder();
        for (int i = 0; i < padLength; i++) {
            padded.append(padChar);
        }

        // 패딩 문자 뒤에 원래 문자열 붙이기
        padded.append(input);

        return padded.toString();
    }
}