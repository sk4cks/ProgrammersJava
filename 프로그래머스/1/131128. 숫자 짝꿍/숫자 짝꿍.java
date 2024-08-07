import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder("-1");
        Map<Character,Integer> xMap = new HashMap<>();
        Map<Character,Integer> yMap = new HashMap<>();
        List<Character> list = new ArrayList<>();

        for(int i=0; i<X.length(); i++){
            xMap.put(X.charAt(i),xMap.getOrDefault(X.charAt(i),0)+1);
        }
        for(int i=0; i<Y.length(); i++){
            yMap.put(Y.charAt(i),yMap.getOrDefault(Y.charAt(i),0)+1);
        }

        for(Character key : xMap.keySet()){
            if(yMap.containsKey(key)){
                int count = Math.min(xMap.get(key),yMap.get(key));
                for(int i=0; i<count; i++){
                    list.add(key);
                }
            }
        }

        Collections.sort(list,Collections.reverseOrder());
        if(list.size()>0){
            answer.setLength(0);
            for(int i=0; i<list.size(); i++){
                answer.append(list.get(i));
            }
            if(answer.charAt(0)=='0'){
                answer.setLength(0);
                answer.append(0);
            }
        }
        return answer.toString();
    }
}