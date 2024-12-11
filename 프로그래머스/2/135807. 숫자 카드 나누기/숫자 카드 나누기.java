import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int aGcd = getGcd(arrayA);
        int bGcd = getGcd(arrayB);
        List<Integer> aCdList = getCdList(aGcd);
        List<Integer> bCdList = getCdList(bGcd);

        aCdList.sort(Comparator.reverseOrder());
        bCdList.sort(Comparator.reverseOrder());

        answer = setAnswer(aCdList,arrayB,answer);
        answer = setAnswer(bCdList,arrayA,answer);
        
        return answer;
    }
    
    int getGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = getGcd(result, arr[i]);
        }
        return result;
    }
    
    int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
    
    List<Integer> getCdList(int gcd) {
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=Math.sqrt(gcd); i++) {
            if(gcd%i == 0) {
                if(i != gcd/i) list.add(gcd/i);
                list.add(i);
            }
        }

        return list;
    }
    
    int setAnswer(List<Integer> list, int[] arr, int answer) {
        Loop:
        for(int i=0; i<list.size()-1; i++) {
            int cd = list.get(i);
            for(int j=0; j<arr.length; j++) {
                if(arr[j]%cd==0) break;
                if(j==arr.length-1) {
                    answer = Math.max(answer,cd);
                    break Loop;
                }
            }
        }

        return answer;
    }
}