import java.util.*;

class Solution {
    String[] arr;
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        arr = numbers.split("");
        visited = new boolean[arr.length];
        
        dfs(0,"");
        
        for(int num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    void dfs(int depth, String number) {
        if(depth == arr.length) return;

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                set.add(Integer.parseInt(number+arr[i]));
                visited[i] = true;
                dfs(depth+1,number+arr[i]);
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int num) {
        if(num<2) return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }

        return true;
    }
}