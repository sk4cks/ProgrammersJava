import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i< cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(list.contains(city)){
                list.remove(city);
                list.add(city);
                answer+=1;
            }else if(list.size()<cacheSize){
                list.add(city);
                answer+=5;
            }else if(list.size()==cacheSize){
                if(list.size()>0){
                    list.remove(0);
                    list.add(city);
                }
                answer +=5;
            }
        }
        return answer;
    }
}