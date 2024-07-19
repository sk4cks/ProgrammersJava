class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        
        return answer;
    }
    
    void dfs(int[] numbers,int target,int number,int index){
        if(index==numbers.length) {
            if(number == target) answer++;
            return;
        }
        dfs(numbers,target,number+numbers[index],index+1);
        dfs(numbers,target,number-numbers[index],index+1);
    }
    
}