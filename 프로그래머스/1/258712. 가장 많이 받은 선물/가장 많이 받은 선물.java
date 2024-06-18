import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String,Integer> futuresIndex = new HashMap<>();
        Map<String, List<String>> exchangedGifts = new HashMap<>();
        Map<String,Integer> result = new HashMap<>();
        int answer = 0;
        
        for(int i=0; i<friends.length; i++){
            futuresIndex.put(friends[i],0);
            result.put(friends[i],0);
            exchangedGifts.put(friends[i],new ArrayList<>());
        }

        /*선물지수와 주고받은 맵 세팅*/
        setGiftsData(gifts,futuresIndex,exchangedGifts);

        for(int i=0; i<friends.length-1; i++){
            List<String> toList = exchangedGifts.get(friends[i]);
            for(int j=i; j<friends.length; j++){
                if(j==i) continue;
                List<String> fromList = exchangedGifts.get(friends[j]);

                /*선물 주고받은 개수 비교*/
                int toCount = Collections.frequency(toList, friends[j]);
                int fromCount = Collections.frequency(fromList, friends[i]);

                if(toCount>fromCount) result.put(friends[i], result.get(friends[i])+1);
                else if(toCount<fromCount) result.put(friends[j], result.get(friends[j])+1);
                else{
                    /*선물지수 비교*/
                    int toIndex = futuresIndex.get(friends[i]);
                    int fromIndex = futuresIndex.get(friends[j]);

                    if(toIndex > fromIndex) result.put(friends[i], result.get(friends[i])+1);
                    else if(toIndex < fromIndex) result.put(friends[j], result.get(friends[j])+1);
                }
            }
        }

        for(String key : result.keySet()){
            if(answer < result.get(key)) answer = result.get(key);
        }
        
        return answer;
    }
    
     public static void setGiftsData(String[] gifts, Map<String,Integer> futuresIndex, Map<String, List<String>> exchangedGifts){
        for(int i=0; i<gifts.length; i++){
            String[] splitGifts = gifts[i].split(" ");
            futuresIndex.put(splitGifts[0],futuresIndex.get(splitGifts[0])+1);
            futuresIndex.put(splitGifts[1],futuresIndex.get(splitGifts[1])-1);

            List<String> list = exchangedGifts.get(splitGifts[0]);
            list.add(splitGifts[1]);
            exchangedGifts.put(splitGifts[0],list);
        }
    }
}