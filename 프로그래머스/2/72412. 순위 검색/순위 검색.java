import java.util.*;

class Solution {
    
    Map<String, List<Integer>> infoMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i=0; i<info.length; i++) {
            setInfoMap(info[i].split(" "), "", 0);
        }

        for (String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }

        for (int i=0; i<query.length; i++) {
            query[i] = query[i].replace(" and ","");
            String[] queryArr = query[i].split(" ");

            if (infoMap.containsKey(queryArr[0])) {
                answer[i] = binarySearch(queryArr[0], Integer.parseInt(queryArr[1]));
            }

        }
        
        return answer;
    }
    
    void setInfoMap(String[] infoArr, String str, int depth) {
        if (depth == 4) {
            if (!infoMap.containsKey(str)) {
                infoMap.put(str, new ArrayList<>());
            }
            infoMap.get(str).add(Integer.parseInt(infoArr[depth]));
            return;
        }

        setInfoMap(infoArr,str + "-", depth + 1);
        setInfoMap(infoArr,str + infoArr[depth], depth + 1);
    }
    
    int binarySearch(String key, int score) {
        List<Integer> list = infoMap.get(key);

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }
    
}