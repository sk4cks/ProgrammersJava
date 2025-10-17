import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;     // 총 실행 시간
        List<String> list = new ArrayList<>();  // 캐시 역할 (가장 오래된 도시가 앞쪽)
        
        // 모든 도시 이름 순서대로 처리
        for(int i=0; i< cities.length; i++) {
            // 대소문자 구분이 없으므로 소문자로 변환
            String city = cities[i].toLowerCase();
            
            // ✅ 1️⃣ 캐시에 이미 있는 경우 (Cache Hit)
            if(list.contains(city)){
                // 최근에 사용했으므로 기존 위치에서 제거 후, 맨 뒤(가장 최근)에 추가
                list.remove(city);
                list.add(city);
                answer+=1;  // Cache Hit → 실행시간 1
                
            // ✅ 2️⃣ 캐시에 공간이 남아있는 경우 (Cache Miss)
            }else if(list.size()<cacheSize){
                list.add(city); // 그냥 캐시에 추가
                answer+=5;      // Cache Miss → 실행시간 5
                
            // ✅ 3️⃣ 캐시가 가득 찬 경우 (Cache Miss + 교체 필요)
            }else if(list.size()==cacheSize){
                if(list.size()>0){
                    list.remove(0); // 가장 오래된 도시(맨 앞)를 제거
                    list.add(city); // 새 도시를 맨 뒤에 추가
                }
                answer +=5;     // Cache Miss → 실행시간 5
            }
        }
        
        return answer;
    }
}