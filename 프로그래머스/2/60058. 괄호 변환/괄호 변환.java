class Solution {
    public String solution(String p) {
       StringBuilder sb = new StringBuilder();

        if(p.isEmpty()) return ""; // 1.

        //2.
        int index = getSplitIndex(p);
        String u = p.substring(0,index);
        String v = p.substring(index);

        
        if(isBalanced(u)) return u + solution(v); //3.
        else{ //4.
            sb.append('(' + solution(v) + ')'); //4 - 1,2,3)
            
            for(int i=1; i<u.length()-1; i++) { //4-4
                if(u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
        }

        return sb.toString(); //4-5
    }
    
    int getSplitIndex(String p) {
        int count = 0;
        int index = 0;

        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') count++;
            else count--;

            if(count == 0) {
                index = i;
                break;
            }
        }

        return index+1;
    }
    
    boolean isBalanced(String u) {
        boolean isValid = true;
        int count = 0;

        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(') count++;
            else count--;

            if(count < 0) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}