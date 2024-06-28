class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {99999,99999,0,0};
        
        for(int i=0; i<wallpaper.length; i++){
           String[] split = wallpaper[i].split("");
           for(int j=0; j< split.length; j++){
               if(split[j].equals("#")){
                   answer[0] = answer[0] > i ? i : answer[0];
                   answer[1] = answer[1] > j ? j : answer[1];
                   answer[2] = answer[2] < i+1 ? i+1 : answer[2];
                   answer[3] = answer[3] < j+1 ? j+1 : answer[3];
               }
           }
       }
        
        return answer;
    }
}