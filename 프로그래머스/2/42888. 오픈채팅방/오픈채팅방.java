import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String,String> nameMap = new HashMap<>();

        Map<String,String> map = new HashMap<>();
        map.put("Enter","%s님이 들어왔습니다.");
        map.put("Leave","%s님이 나갔습니다.");

        for(int i=0; i<record.length; i++) {
            String[] arr = record[i].split(" ");
            if(map.get(arr[0]) != null){
                list.add(map.get(arr[0])+","+arr[1]);
            }
            if(arr.length>2) nameMap.put(arr[1],arr[2]);
        }

        for(int i=0; i<list.size(); i++){
            String[] arr = list.get(i).split(",");
            list.set(i,String.format(arr[0],nameMap.get(arr[1])));
        }
        return list.toArray(new String[0]);
    }
}