import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = new int[data.length][4];
        int extIndex = getIndex(ext);
        for(int i=0; i<data.length; i++){
            if(data[i][extIndex] < val_ext){
                answer[i] = data[i];
            }
        }
        
        answer = Arrays.stream(answer).filter(o -> o[0]!=0).toArray(int[][]::new);
        
        int sortIndex = getIndex(sort_by);
        
        Arrays.sort(answer,(o1,o2) -> { return o1[sortIndex]-o2[sortIndex]; });
        
        return answer;
    }
    
       
    public int getIndex(String indexString) {
        String[] sortArr = {"code","date","maximum","remain"};
        int result = 0;
        
        for(int i=0; i<sortArr.length; i++){
            if(sortArr[i].equals(indexString)){
                result = i;
            }
        }
        
        return result;
    }
}