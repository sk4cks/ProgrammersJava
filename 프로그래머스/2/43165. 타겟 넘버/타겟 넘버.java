class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        search(numbers,target,-numbers[0],0);
        search(numbers,target,+numbers[0],0);
        
        return answer;
    }
    
    static void search(int[] numbers,int target,int number,int index){
        if(index==numbers.length-1) {
            if(number == target) answer++;
            return;
        }
        search(numbers,target,number+numbers[index+1],index+1);
        search(numbers,target,number-numbers[index+1],index+1);
    }
    
}