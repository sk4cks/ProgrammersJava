class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        char[] arr = number.toCharArray();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<=k+i; j++) {
                if(j==arr.length || arr[i]==9) break;
                if(arr[i] < arr[j]) {
                    sb.setCharAt(i,' ');
                    k--;
                    break;
                }
            }
            if(k==0) break;
        }

        if(k>0) {
            for(int i=sb.length()-1; i>=sb.length()-k; i--) {
                sb.setCharAt(i,' ');
            }
        }
        
        return sb.toString().replaceAll(" ","");
    }
}