class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.split("[a-zA-Z]+");
        int answer = 0;

        for(int i=0; i<arr.length; i++) {
            if(!arr[i].isEmpty()) {
                answer += Integer.parseInt(arr[i]);
            }
        }
        
        return answer;
    }
}