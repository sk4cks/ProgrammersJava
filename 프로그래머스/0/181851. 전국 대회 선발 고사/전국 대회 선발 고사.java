import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> list =  Arrays.stream(rank)
            .boxed().collect(Collectors.toList());
        List<Integer> selectionList = new ArrayList<>();

        for(int i=1; i<=rank.length; i++) {
            int index = list.indexOf(i);
            if(attendance[index]) selectionList.add(index);
            if(selectionList.size() == 3) break;
        }
        
        return (selectionList.get(0) * 10000) 
            + (selectionList.get(1) * 100) 
            + selectionList.get(2);
    }
}