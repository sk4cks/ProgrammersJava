class Solution {
    public int[] solution(int[] arr, int n) {
        int flag = arr.length%2;

        for(int i=0; i<arr.length; i++) {
            if(i%2 != flag) arr[i] += n;
        }
        
        return arr;
    }
}