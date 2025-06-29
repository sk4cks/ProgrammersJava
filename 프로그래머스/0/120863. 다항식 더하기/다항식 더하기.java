class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" ");
        int variable = 0;
        int constant = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].endsWith("x")) {
                String tmp = arr[i].replace("x","");
                variable += tmp.length() == 0 ? 1 : Integer.parseInt(tmp);
            }else if(arr[i].matches("\\d+")) {
                constant += Integer.parseInt(arr[i]);
            }
        }
        
        if(variable > 0 && constant > 0) {
            answer = (variable== 1 ? "x" : variable+"x") + " + " + constant;
        }else if(variable == 0 && constant > 0) {
            answer = constant + "";
        }else if(variable > 0 && constant == 0) {
            answer = variable== 1 ? "x" : variable+"x";
        }
        
        return answer;
    }
}