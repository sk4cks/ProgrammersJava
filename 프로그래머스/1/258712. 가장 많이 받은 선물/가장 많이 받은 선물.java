import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        // 각 친구의 "선물 지수" 저장 (준 선물 - 받은 선물)
        Map<String,Integer> futuresIndex = new HashMap<>();
        
        // 누가 누구에게 선물을 줬는지 기록
        // key: 준 사람, value: 받은 사람들의 목록
        Map<String, List<String>> exchangedGifts = new HashMap<>();
        
        // 다음 달에 받을 선물 개수 저장
        Map<String,Integer> result = new HashMap<>();
        
        int answer = 0;
        
        // 초기 세팅
        for(int i=0; i<friends.length; i++){
            futuresIndex.put(friends[i],0);
            result.put(friends[i],0);
            exchangedGifts.put(friends[i],new ArrayList<>());
        }

        /*선물지수와 주고받은 맵 세팅*/
        setGiftsData(gifts,futuresIndex,exchangedGifts);

        /* 2. 모든 친구 쌍에 대해 다음 달에 누가 선물을 받을지 계산 */
        for(int i=0; i<friends.length-1; i++){
            List<String> toList = exchangedGifts.get(friends[i]);
            for(int j=i; j<friends.length; j++){
                if(j==i) continue;
                List<String> fromList = exchangedGifts.get(friends[j]);

                /* (1) 서로 주고받은 선물 개수 비교 */
                int toCount = Collections.frequency(toList, friends[j]);
                int fromCount = Collections.frequency(fromList, friends[i]);

                // i가 j에게 더 많이 줬으면 i가 다음 달 선물 받음
                if(toCount>fromCount) result.put(friends[i], result.get(friends[i])+1);
                
                // j가 i에게 더 많이 줬으면 j가 다음 달 선물 받음
                else if(toCount<fromCount) result.put(friends[j], result.get(friends[j])+1);
                
                else{
                    /* (2) 주고받은 개수가 같으면 선물 지수 비교 */
                    int toIndex = futuresIndex.get(friends[i]);
                    int fromIndex = futuresIndex.get(friends[j]);

                    if(toIndex > fromIndex) result.put(friends[i], result.get(friends[i])+1);
                    else if(toIndex < fromIndex) result.put(friends[j], result.get(friends[j])+1);
                    // 선물 지수도 같으면 아무도 받지 않음
                }
            }
        }

        /* 3. 가장 많이 받은 선물 개수 찾기 */
        for(String key : result.keySet()){
            if(answer < result.get(key)) answer = result.get(key);
        }
        
        return answer;
    }
    
    // 선물 기록을 기반으로 선물 지수와 주고받은 목록 구성
     public static void setGiftsData(String[] gifts, Map<String,Integer> futuresIndex, Map<String, List<String>> exchangedGifts){
        for(int i=0; i<gifts.length; i++){
            String[] splitGifts = gifts[i].split(" ");
            
            // 선물 지수 계산 (준 사람 +1, 받은 사람 -1)
            futuresIndex.put(splitGifts[0],futuresIndex.get(splitGifts[0])+1);
            futuresIndex.put(splitGifts[1],futuresIndex.get(splitGifts[1])-1);

            // 누가 누구에게 줬는지 기록
            List<String> list = exchangedGifts.get(splitGifts[0]);
            list.add(splitGifts[1]);
            exchangedGifts.put(splitGifts[0],list);
        }
    }
}