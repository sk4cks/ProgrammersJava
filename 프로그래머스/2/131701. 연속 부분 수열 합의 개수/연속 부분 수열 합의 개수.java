import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<= elements.length; i++){
           getCount(i,elements,set);
        }
        return set.size();
    }
    
    void getCount(int i, int[] elements, Set<Integer> set){
        int subSequence = 0;
        
        for(int j=0;j<elements.length;j++){
            subSequence = 0;
            for(int k=0; k<i; k++){
                int index = j+k;
                if(j+k > elements.length-1) index = j+k- elements.length;
                subSequence +=elements[index];
            }
            set.add(subSequence);
        }
    }
    
}