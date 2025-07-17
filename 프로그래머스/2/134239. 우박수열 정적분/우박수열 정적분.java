import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        double[] answer = new double[ranges.length];
        list.add(k);
        
        while (k > 1) {
            if(k%2 == 0) {
                k /= 2;
            }else{
                k = k * 3 + 1;
            }
            list.add(k);
        }
        
        double[] areaSumList = new double[list.size()];
        for(int i=1; i<areaSumList.length; i++) {
            double area = (list.get(i) + list.get(i-1)) / 2.0;
            areaSumList[i] = areaSumList[i-1] + area;
        }
        
        for(int i=0; i<ranges.length; i++) {
            int s = ranges[i][0];
            int e = list.size() - 1 + ranges[i][1];

            if(s > e) {
                answer[i] = -1;
            }else{
                answer[i] = areaSumList[e] - areaSumList[s];
            }
        }
        
        return answer;
    }
}