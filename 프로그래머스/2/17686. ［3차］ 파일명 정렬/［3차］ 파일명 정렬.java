import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, Comparator.comparing(
            s -> ((String) s).toLowerCase().replaceAll("\\d.*",""))
                .thenComparing(
                    s -> Integer.parseInt(((String) s).replaceAll(".*?(\\d+).*", "$1"))));
        
        return files;
    }
}