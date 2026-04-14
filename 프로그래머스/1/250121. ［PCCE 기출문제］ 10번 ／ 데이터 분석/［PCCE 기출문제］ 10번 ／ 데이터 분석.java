import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> list = new ArrayList<>();
        
        int extIndex = getIndex(ext);
        
        // 조건 만족하는 데이터만 추가
        for(int[] d : data){
            if(d[extIndex] < val_ext){
                list.add(d);
            }
        }
        
        int sortIndex = getIndex(sort_by);
        
        // 정렬
        list.sort((o1, o2) -> o1[sortIndex] - o2[sortIndex]);
        
        return list.toArray(new int[0][]);
    }
    
    public int getIndex(String indexString) {
        String[] arr = {"code","date","maximum","remain"};
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals(indexString)) return i;
        }
        return 0;
    }
}