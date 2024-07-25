import java.util.HashMap;
import java.util.Map;

class Solution {
    
    Map<Integer,Integer> map = new HashMap<>();
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        dfs(3,brown);

        for(int key : map.keySet()){
            int width = key-2;
            int height = map.get(key)-2;
            int count = 0;

            while (width > 2 && height > 2){
                count += (width*2 + height*2) -4;
                width -= 2;
                height -= 2;
            }
            count += width * height;

            if(count == yellow) {
                answer[0] = key;
                answer[1] = map.get(key);
                break;
            }
        }
        return answer;
    }
    
    void dfs(int width, int brown) {
        if(brown <= width) return;

        for(int i=3; i<=width; i++){
            if((width*2 + i*2) -4 == brown){
                map.put(width,i);
                break;
            }
        }

        dfs(width+1,brown);
    }
}