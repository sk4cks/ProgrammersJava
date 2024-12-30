class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++) {
            if(Character.isLowerCase(arr[i])) 
                sb.append(Character.toUpperCase(arr[i]));
            
            else sb.append(Character.toLowerCase(arr[i]));
        }
        return sb.toString();
    }
}