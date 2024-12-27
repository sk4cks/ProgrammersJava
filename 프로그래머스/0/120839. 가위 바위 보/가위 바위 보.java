class Solution {
    public String solution(String rsp) {
        char[] arr = rsp.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++) {
            switch (arr[i]){
                case '2':
                    sb.append('0');
                    break;
                case '0':
                    sb.append('5');
                    break;
                case '5':
                    sb.append('2');
                    break;
            }
        }
        
        return sb.toString();
    }
}