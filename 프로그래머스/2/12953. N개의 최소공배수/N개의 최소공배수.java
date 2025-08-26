class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        for(int i=0; i<arr.length-1; i++){
            int gcd = getGcd(arr[i],arr[i+1]); //최대공약수
            arr[i+1] = (arr[i]*arr[i+1])/gcd; //최대공배수
        }
        
        answer = arr[arr.length-1];
        
        return answer;
    }
    
    //최대공약수 구하기
    int getGcd(int a, int b) {
        if(a%b == 0) return b;
        return getGcd(b,a%b);
    }
}