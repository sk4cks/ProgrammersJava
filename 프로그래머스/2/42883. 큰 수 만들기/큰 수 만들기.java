class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        int index = 0;
        char max = 0;

        for(int i=0; i<arr.length-k; i++) {
            max = 0;
            for(int j=index; j<=i+k; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    index = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}