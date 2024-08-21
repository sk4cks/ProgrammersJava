import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        setList(list1,str1);
        setList(list2,str2);

        for(int i=list1.size()-1; i>=0; i--){
            String word = list1.get(i);
            if(list2.indexOf(word) != -1){
                intersection.add(word);
                list1.remove(i);
                list2.remove(list2.indexOf(word));
            }
        }

        int unionSize = intersection.size()+list1.size()+ list2.size();

        if(intersection.size()==0 && unionSize==0) answer=65536;
        else answer = (int) ((intersection.size()/(double) unionSize)*65536);
        
        return answer;
    }
    
    void setList(List<String> list, String str) {
        for(int i=0; i<str.length()-1; i++){
            String word = 
                (String.valueOf(str.charAt(i))+str.charAt(i+1)).toLowerCase();
            if(Pattern.matches("^[a-z]*$",word)) list.add(word);
        }
    }
}