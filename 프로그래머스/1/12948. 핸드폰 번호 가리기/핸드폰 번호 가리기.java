class Solution {
    public String solution(String phone_number) {
        return phone_number.replaceAll(".(?=\\d{4})", "*");
    }
}