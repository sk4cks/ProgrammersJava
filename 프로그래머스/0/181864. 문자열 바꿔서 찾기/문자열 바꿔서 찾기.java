class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replace("A"," ").replace("B","A").replace(" ","B");
        return myString.contains(pat) ? 1 : 0;
    }
}