class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] arr = {"수","박"};

        for(int i=0; i<n; i++){
            sb.append(arr[i%2]);
        }
        
        return sb.toString();
    }
}