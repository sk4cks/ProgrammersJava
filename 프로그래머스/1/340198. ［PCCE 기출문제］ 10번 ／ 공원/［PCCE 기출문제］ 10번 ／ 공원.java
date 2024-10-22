import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int matsIndex = 0;

        Arrays.sort(mats);

        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length; j++) {
                if(park[i][j].equals("-1")){

                    Loop1 :
                    for(int k=matsIndex; k<mats.length; k++) {
                        if(i+mats[k] > park.length || j+mats[k] > park[i].length) 
                            break;

                        for(int l=i; l<i+mats[k]; l++) {
                            for(int m=j; m<j+mats[k]; m++) {
                                if(!park[l][m].equals("-1")) break Loop1;
                            }
                        }
                        matsIndex = k;
                        answer = mats[k];
                    }
                }
            }
        }
        return answer;
    }
}