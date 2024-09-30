import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] arr = new int[3];
        String temp = "";
        int idx = 0;

        for(int i=0; i<dartResult.length(); i++){
            char word = dartResult.charAt(i);

            if(word == '#') arr[idx-1] *= -1;
            else if(word == '*') {
                for(int j=idx-1; j>=idx-2; j--) {
                    arr[j] *= 2;
                    if(j==0) break;
                }
            }
            else if(48 <= word && word <= 57) temp += dartResult.charAt(i);
            else {
                int pow = 1;
                if(word == 'D') pow = 2;
                else if(word == 'T') pow = 3;

                arr[idx++] = (int) Math.pow(Integer.parseInt(temp),pow);
                temp = "";
            }
        }

        answer = Arrays.stream(arr).sum();
        return answer;
    }
}