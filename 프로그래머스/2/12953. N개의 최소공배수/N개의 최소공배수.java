class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        for(int i=0; i<arr.length-1; i++){
            int gcd = getGcd(arr[i],arr[i+1]);
            arr[i+1] = (arr[i]*arr[i+1])/gcd;
        }
        answer = arr[arr.length-1];
        
        return answer;
    }
    
    int getGcd(int a, int b) {
        if(a%b == 0) return b;
        return getGcd(b,a%b);
    }
}