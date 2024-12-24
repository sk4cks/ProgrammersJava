class Solution {
    public int solution(int price) {
        return price < 100000 ? price : price < 300000 ? (int) (price*0.95) : price < 500000 ? (int) (price*0.9) : (int) (price*0.8) ;
    }
}